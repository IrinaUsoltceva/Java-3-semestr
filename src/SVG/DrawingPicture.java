package SVG;

public class DrawingPicture {
    public static void main(String[] args) {
        Tag rect1 = new Tag("rect");
        rect1.set("x", "50");
        rect1.set("y", "50");
        rect1.set("width", "100");
        rect1.set("height", "200");
        rect1.set("style", "stroke:#ff0000; fill: #00ffff");

        Tag rect2 = new Tag("rect");
        rect2.set("x", "170");
        rect2.set("y", "50");
        rect2.set("width", "100");
        rect2.set("height", "100");
        rect2.set("style", "stroke:#ff0000; fill: #01befe");

        Tag circle1 = new Tag("circle");
        circle1.set("cx", "220");
        circle1.set("cy", "220");
        circle1.set("r", "50");
        circle1.set("style", "stroke:#ff00ff; fill: #41ffcf");

        try (SVG svg = new SVG("a.svg", 300, 300)) {
            svg.addTag(rect1);
            svg.addTag(rect2);
            svg.addTag(circle1);
        } catch (Exception e) {
            System.out.println("ошибка записи");
        }
    }




}
