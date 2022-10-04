package hello_sign_poc.hellosign;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.support.Document;
import com.hellosign.sdk.resource.support.FormField;
import com.hellosign.sdk.resource.support.types.FieldType;
import hello_sign_poc.dto.BoxDimensions;
import hello_sign_poc.dto.ContractData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ContractGenerator {
    private final HelloSignClient client;

    public ContractGenerator(final String apiKey) {
        client = new HelloSignClient(apiKey);
    }

    public SignatureRequest sendNewSignatureRequest(final ContractData contractData, final byte[] data,
                                                    final BoxDimensions firstSingerBox, final BoxDimensions secondSignerBox) {
        SignatureRequest request = new SignatureRequest();
        request.setSubject(contractData.getContractName());
        request.setMessage("Hi, please approve this media.");
        //can add cc to the email
        //request.addCC("somevalidemail.gmail.com");
        request.setTestMode(true);
        try {
            request.addSigner(contractData.getFirstContact().getEmail(), contractData.getFirstContact().getName());
            request.addSigner(contractData.getSecondContact().getEmail(), contractData.getSecondContact().getName());
            request.addDocument(this.generateDocument(contractData, data, firstSingerBox, secondSignerBox));

            return client.sendSignatureRequest(request);
        } catch (HelloSignException e) {
            throw new RuntimeException(e);
        }
    }

    private Document generateDocument(final ContractData contractData, final byte[] data,
                                      final BoxDimensions firstSignerBox, final BoxDimensions secondSignerBox) throws HelloSignException {
        final Document document = new Document();
        File file = createTempFile(contractData, data);
        document.setName(contractData.getContractName());
        document.setFile(file);

        final ArrayList<FormField> formFields = new ArrayList<>();
        final int page = 1;
        final int OFFSET_X = 24; // For some reason HelloSign is not using correct X position.
        final FormField firstSignerName = new FormField(FieldType.TEXT, "Print Name",
                0, firstSignerBox.getX() + OFFSET_X, firstSignerBox.getY(), 20, 200, page);
        firstSignerName.setIsRequired(true);
        formFields.add(firstSignerName);

        final FormField firstSign = new FormField(FieldType.SIGNATURE, "Signature",
                0, firstSignerBox.getX() + OFFSET_X + firstSignerName.getWidth(),
                firstSignerBox.getY(), 20, 200, page);

        firstSign.setIsRequired(true);
        formFields.add(firstSign);

        final FormField secondSignerName = new FormField(FieldType.TEXT, "Print Name",
                1, secondSignerBox.getX() + OFFSET_X, secondSignerBox.getY(), 20, 200, page);
        secondSignerName.setIsRequired(true);
        formFields.add(secondSignerName);

        final FormField secondSign = new FormField(FieldType.SIGNATURE, "Signature",
                1, secondSignerBox.getX() + OFFSET_X + secondSignerName.getWidth(),
                secondSignerBox.getY(), 20, 200, page);
        secondSign.setIsRequired(true);
        formFields.add(secondSign);

        document.setFormFields(formFields);
        return document;
    }

    private File createTempFile(final ContractData contractData, final byte[] data) {
        try {
            File file = File.createTempFile("Campaign_" + contractData.getContractName(),
                    ".pdf",
                    new File(ContractGenerator.class.getClassLoader().getResource("contracts").getFile()));
            final FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.flush();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
