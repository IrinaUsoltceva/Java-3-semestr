package SVG;

import java.io.PrintStream;

public class SVG {

    private String fileSvoistva;
    private String svgName;
/*
* вынести принтстрим вне всего как поле, но заводить в первой штуке
* все верно, но сделать так, чтобы н закрывался, финальный тэг закрытия свг
* отправляется в клозе
* */
    public SVG(String svgName, int width, int height) {
        this.svgName = svgName;
        fileSvoistva = "<svg  xmlns=\"http://www.w3.org/2000/svg\" " +
                "width=\"" + width + "\" " +
                "height=\"" + height + "\"> ";
        try (PrintStream fileOut = new PrintStream(svgName, "UTF-8")) {
            fileOut.println(fileSvoistva + "</svg>");
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }

    public void addTag(Tag tag) {
        try (PrintStream fileOut = new PrintStream(svgName, "UTF-8")) {
            fileSvoistva = fileSvoistva + "<" + tag.getType() + " ";
            tag.getM().forEach((key, value) -> {
                fileSvoistva = fileSvoistva + " " + key + "=\"" + value + "\"";
            });
            fileOut.println(fileSvoistva + "/>");
            fileOut.println("</svg>");
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
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
