package hello_sign_poc;

import hello_sign_poc.dto.ContractData;
import hello_sign_poc.hellosign.ContractGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static hello_sign_poc.HtmlGeneratorTest.TEST_HTML;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfGeneratorTest {

    @Test
    void shouldGeneratePDF() {

        final PdfGenerator pdfGenerator = new PdfGenerator();

        final byte[] result = pdfGenerator.generatePDF(TEST_HTML, "test.pdf");

        createTestFile(result);

        assertTrue(result.length > 0);
    }

    private File createTestFile(final byte[] data) {
        try {
            File file = new File("test.pdf");
            final FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.flush();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
