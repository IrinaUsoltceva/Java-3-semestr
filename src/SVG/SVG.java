package SVG;

import java.io.PrintStream;

public class SVG implements AutoCloseable {

    private PrintStream fileOut;

    public SVG(String svgName, int width, int height) throws Exception {
        fileOut = new PrintStream(svgName, "UTF-8");
        String fileSvoistva = "<svg  xmlns=\"http://www.w3.org/2000/svg\" " +
                "width=\"" + width + "\" " +
                "height=\"" + height + "\"> ";
        fileOut.println(fileSvoistva);

        Tag background = new Tag("rect");
        background.set("width", String.valueOf(width));
        background.set("height", String.valueOf(height));
        background.set("fill", Settings.getInstance().getBackground());

        addTag(background);
    }

    public void addTag(Tag tag) {
        if (tag.getTagType().equals(TagType.OPEN)) {
            printTag(tag, "<", ">");
            return;
        }
        if (tag.getTagType().equals(TagType.OPEN_AND_CLOSE)) {
            printTag(tag, "<", "/>");
            return;
        }
        if (tag.getTagType().equals(TagType.CLOSE)) {
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
