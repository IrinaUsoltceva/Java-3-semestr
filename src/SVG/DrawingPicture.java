package SVG;

import java.util.Random;
// напомнить, что виснет
public class DrawingPicture {
    public static void main(String[] args) {
        try (SVG svg = new SVG("a.svg",
                                Settings.getInstance().getWidth(),
                                Settings.getInstance().getHeight())
            ) {

            Random random;
            long randSeed = Settings.getInstance().getRandSeed();
            if (randSeed != 0)
                random = new Random(Settings.getInstance().getRandSeed());
            else
                random = new Random();
            System.out.println(Settings.getInstance().getRandSeed());

            for (int i = 0; i < 1000; i++) {
                PositionedShape f = new PositionedShape(new SmallSquare(), random.nextInt(400), random.nextInt(400));
                f.draw(svg);
            }

            for (int i = 0; i < 1500; i++) {
                PositionedShape f = new PositionedShape(new RedCircle(), random.nextInt(400), random.nextInt(400));
                f.draw(svg);
            }


        } catch (Exception e) {
            System.out.println("ошибка записи");
        }
    }
}
