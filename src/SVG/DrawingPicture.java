package SVG;

public class DrawingPicture {
    public static void main(String[] args) {
        Tag rect1 = new Tag("rect");
        rect1.set("x", "50");
        rect1.set("y", "50");
        rect1.set("width", "100");
        rect1.set("height", "200");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");

        SVG svg = new SVG("a.svg", 300, 300);
        svg.addTag(rect1);
        svg.addTag(rect1);
    }




}
