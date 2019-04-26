package SVG;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SVG implements AutoCloseable {

    private PrintStream fileOut;

    public SVG(String svgName, int width, int height) throws Exception {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(svgName));
        fileOut = new PrintStream(outputStream, false, "UTF-8");

        String fileSvoistva = "<svg  xmlns=\"http://www.w3.org/2000/svg\" " +
                "width=\"" + width + "\" " +
                "height=\"" + height + "\"> ";
        fileOut.println(fileSvoistva);

        Tag background = new Tag("rect");
        background.set("width", String.valueOf(width));
        background.set("height", String.valueOf(height));
        background.set("fill", Settings.getInstance().getBackground());

        addTag(background);
        fileOut.flush();
    }

    public void addTag(Tag tag) {
        switch (tag.getTagType()) {
            case OPEN:
                printTag(tag, "<", ">");
                return;
            case OPEN_AND_CLOSE:
                printTag(tag, "<", "/>");
                return;
            case CLOSE:
                printTag(tag, "</", ">");
        }
    }

    private void printTag(Tag tag, String s, String s2) {
        fileOut.print(s + tag.getTagName());
        tag.getM().forEach((key, value) -> fileOut.print(" " + key + "=\"" + value + "\""));
        fileOut.println(s2);
    }

    public void close() throws Exception {
        fileOut.println("</svg>");
        fileOut.close();
    }
}
