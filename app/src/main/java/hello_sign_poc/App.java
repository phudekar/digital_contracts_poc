package hello_sign_poc;

import com.hellosign.sdk.resource.SignatureRequest;
import hello_sign_poc.dto.Contact;
import hello_sign_poc.dto.ContractData;
import hello_sign_poc.dto.DataModel;
import hello_sign_poc.hellosign.ContractGenerator;

public class App {
    //Need to add valid api key
    private static final String API_KEY = "";

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        final PdfGenerator pdfGenerator = new PdfGenerator();
        final HtmlGenerator generator = new HtmlGenerator();

        //generate html from template
        final String generatedHtml = generator.generateHtml("test", new DataModel());
        System.out.println(generatedHtml);

        //generate pdf from html
        final byte[] data = pdfGenerator.generatePDF(generatedHtml);
        pdfGenerator.writePDF(generatedHtml);

        ContractGenerator contractGenerator = new ContractGenerator(API_KEY);
        final ContractData contractData = new ContractData(
                "Test Contract",
                new Contact("signer1", "somevalidemail.gmail.com"),
                new Contact("sighner2", "somevalidemail.gmail.com")
        );
        final SignatureRequest response = contractGenerator.sendNewSignatureRequest(
                contractData,
                data,
                pdfGenerator.getBoxForId("sign-1"),
                pdfGenerator.getBoxForId("sign-2")
        );


    }
}
