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
    }

    public void addTag(Tag tag) {
        fileOut.print("<" + tag.getFigureName() + " ");
        tag.getM().forEach((key, value) -> fileOut.print(key + "=\"" + value + "\" "));
        fileOut.println("/>");
    }

    public void close() throws Exception {
        fileOut.println("</svg>");
        fileOut.close();
    }

    /*1. Класс SVG, содержит открытый PrintStream для печати SVG:
    ```
        SVG svg = new SVG("a.svg", 300, 300);
        svg.addTag(rect1);
        svg.addTag(rect2);
        svg.close();
    ```
    В конце обязательно будет вызвано закрытие, чтобы закрыть PrintStream
    PrintStream - класс, который позволяет удобно печатать файл
    * */


}
