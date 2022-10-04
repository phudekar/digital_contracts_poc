package hello_sign_poc;

import hello_sign_poc.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlGeneratorTest {
    public static String TEST_HTML = "<html>\n" +
            "<head>\n" +
            "    <title>Digital Contract</title>\n" +
            "</head>\n" +
            "<style>\n" +
            "    @page { size: letter landscape; margin: 1cm;}\n" +
            "    body { font-family: sans-serif; }\n" +
            "    .terms { height: 1000px; }\n" +
            "    .signer {\n" +
            "        margin-bottom: 40px;\n" +
            "    }\n" +
            "    .sign {\n" +
            "        height:40px;\n" +
            "        margin-top: 24px;\n" +
            "        margin-bottom: 12px;\n" +
            "        width: 400px;\n" +
            "        border-bottom: solid 1px black;\n" +
            "      }" +
            "</style>\n" +
            "<body>\n" +
            "<h1>This is a test Contract</h1>\n" +
            "<div class=\"terms\">Terms and Conditions:\n" +
            "    Read carefully!\n" +
            "</div>\n" +
            "\n" +
            "<p>\n" +
            "<div class=\"signer\">\n" +
            "    <div>Signer 1: [text|req|signer1|Label|UniqueId|letters_only|name]</div>\n" +
            "    <div>Email: [text|noreq|signer1|Label|UniqueId|email_address|email]</div>\n" +
            "    <div class=\"sign\">Sign: [sig|req|signer1]</div>\n" +
            "    <div>Signed On: [date|req|signer1]</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"signer\">\n" +
            "    <div>Signer 2: [text|req|signer2|Label|UniqueId|letters_only|name]</div>\n" +
            "    <div>Email: [text|noreq|signer2|Label|UniqueId|email_address|email]</div>\n" +
            "    <div class=\"sign\">Sign: [sig|req|signer2]</div>\n" +
            "    <div>Signed On: [date|req|signer2]</div>\n" +
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
