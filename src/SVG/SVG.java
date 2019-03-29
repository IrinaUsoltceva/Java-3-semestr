package SVG;

import java.io.PrintStream;
import java.util.Map;

public class SVG {

    public SVG(String SVGname, int width, int height) {
        try (PrintStream fileOut = new PrintStream(SVGname, "UTF-8")) {
            fileOut.println("<svg  xmlns=\"http://www.w3.org/2000/svg\"" +
                            "width=\"" + width + "\"" +
                            "height=\"" + height + "\"" +
                            "</svg>");
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }

    public void addTag(Tag tag) {

    }



 /*   public void printMap(Map<String, Integer> map) {
        try (PrintStream fileOut = new PrintStream(this.SVGname, "UTF-8")) {
            map.forEach((key, value) -> {
                fileOut.println(key + "=" + value);
            });
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }
    */

    /*1. Класс SVG, содержит открытый PrintStream для печати SVG:
    ```
        Svg svg = new SVG("a.svg", 300, 300);
        svg.addTag(rect1);
        svg.addTag(rect2);
        svg.close();
    ```
    В конце обязательно будет вызвано закрытие, чтобы закрыть PrintStream
    PrintStream - класс, который позволяет удобно печатать файл
    * */


}
