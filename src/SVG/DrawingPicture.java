package SVG;

import java.util.Random;

public class DrawingPicture {
    public static void main(String[] args) {
        try (SVG svg = new SVG("a.svg",
                                Settings.getInstance().getWidth(),
                                Settings.getInstance().getHeight())) {

            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                PositionedShape f = new PositionedShape(new SmallSquare(), random.nextInt(400), random.nextInt(400));
                f.draw(svg);
            }

            for (int i = 0; i < 150; i++) {
                PositionedShape f = new PositionedShape(new RedCircle(), random.nextInt(400), random.nextInt(400));
                f.draw(svg);
            }


        } catch (Exception e) {
            System.out.println("ошибка записи");
        }
    }
}
