package hello_sign_poc;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

@Slf4j
public class HtmlGenerator {

    private Configuration cfg;

    public HtmlGenerator() {
        this.configure();
    }

    public String generateHtml(final String template, final HashMap<String, Object> model) {
        try {
            Template temp = cfg.getTemplate(template + ".ftlh");
            Writer out = new StringWriter();
            temp.process(model, out);
            return out.toString();
        } catch (final IOException | TemplateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void configure() {
// Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.29) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_29);

        try {
            cfg.setDirectoryForTemplateLoading(new File(HtmlGenerator.class.getClassLoader().getResource("templates").getFile()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);
// Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

    }
}
