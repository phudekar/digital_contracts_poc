package hello_sign_poc;

import hello_sign_poc.dto.BoxDimensions;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.render.Box;
import org.xhtmlrenderer.render.InlineLayoutBox;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class PdfGenerator {

    private final ITextRenderer renderer;
    private final int DOTS_PER_PIXEL = 3;
    private final float DOTS_PER_POINT = 4.1666f;

    public PdfGenerator() {
        renderer = new ITextRenderer(DOTS_PER_POINT, DOTS_PER_PIXEL);
        SharedContext sharedContext = renderer.getSharedContext();
        sharedContext.setPrint(true);
        sharedContext.setInteractive(false);

    }

    public byte[] generatePDF(final String htmlString, final String outputFileName) {
        final Document document = getXHtmlDocument(htmlString);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (OutputStream outputStream = new BufferedOutputStream(out)) {
            renderer.setDocumentFromString(document.html());
            renderer.layout();
            renderer.createPDF(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    private Document getXHtmlDocument(final String htmlString) {
        Document document = Jsoup.parse(htmlString, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

    public BoxDimensions getBoxForId(final String elementId) {
        final Box box = findChildBoxWithId(renderer.getRootBox().getElementBoxes(null), elementId);
        return new BoxDimensions((box.getAbsX() + box.getBorderSides()) / DOTS_PER_PIXEL, box.getAbsY() / DOTS_PER_PIXEL,
                box.getWidth() / DOTS_PER_PIXEL, box.getHeight() / DOTS_PER_PIXEL);
    }

    public Box findChildBoxWithId(List<Box> boxes, String id) {
        if (boxes == null || boxes.size() == 0) {
            return null;
        }
        Box result = null;
        for (Box box : boxes) {
            if (result == null && box.getClass().equals(InlineLayoutBox.class)) {
                InlineLayoutBox layoutBox = (InlineLayoutBox) box;
                if (layoutBox.getElement() != null && Objects.equals(layoutBox.getElement().getAttribute("id"), id)) {
                    result = layoutBox;
                } else {
                    result = findChildBoxWithId(getChildren(layoutBox), id);
                }
            }
        }
        return result;
    }

    private List<Box> getChildren(final InlineLayoutBox layoutBox) {
        return (List<Box>) layoutBox.getInlineChildren().stream()
                .filter(c -> {
                    try {
                        Box b = (Box) c;
                        return true;
                    } catch (ClassCastException e) {
                        return false;
                    }
                }).collect(Collectors.toList());
    }
}
