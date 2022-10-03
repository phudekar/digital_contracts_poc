package hello_sign_poc;

import hello_sign_poc.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlGeneratorTest {
    public static String TEST_HTML = "<html>\n" +
            "<head>\n" +
            "    <meta name=\"viewport\" content=\"width=1980, initial-scale=1\"/>\n" +
            "    <title>Welcome!</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>This is a test Contract</h1>\n" +
            "<p>Terms and Conditions:\n" +
            "    Read carefully!\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "<div id=\"first-signer\">\n" +
            "    <div>\n" +
            "        <span>First Signer:</span>\n" +
            "        <span id=\"sign-1\"></span>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div id=\"second-signer\">\n" +
            "    <div>\n" +
            "        <span>Second Signer:</span>\n" +
            "        <span id=\"sign-2\"></span>\n" +
            "    </div>\n" +
            "</div>\n" +
            "</p>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    @Test
    void shouldGenerateTestHtml() {
        final HtmlGenerator generator = new HtmlGenerator();
        final HashMap<String, Object> model = new HashMap<>();
        model.put("user", "John");
        model.put("latestProduct", new Product("Product_Name", "http://abc.com"));
        final String result = generator.generateHtml("test", model);
        assertEquals(TEST_HTML, result);
    }
}
