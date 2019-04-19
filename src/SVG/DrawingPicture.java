package SVG;

public class DrawingPicture {
    public static void main(String[] args) {
        try (SVG svg = new SVG("a.svg", 300, 300)) {

            SmallSquare sq = new SmallSquare();
            RedCircle rc = new RedCircle();

            PositionedShape ps1 = new PositionedShape(sq, 100, 100);
            PositionedShape ps2 = new PositionedShape(sq, 200, 200);
            PositionedShape ps3 = new PositionedShape(rc, 100, 200);
            PositionedShape ps4 = new PositionedShape(rc, 200, 100);

            ps1.draw(svg);
            ps2.draw(svg);
            ps3.draw(svg);
            ps4.draw(svg);

        } catch (Exception e) {
            System.out.println("ошибка записи");
        }
    }
}
