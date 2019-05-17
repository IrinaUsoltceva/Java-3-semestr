package SVG;

import java.util.Map;
import java.util.Random;

public class DrawingPicture {
    public static void main(String[] args) {
        drawFromSettings();
    }

    public static String drawFromSettings() {
        try (SVG svg = new SVG("a.svg",
                Settings.getInstance().getWidth(),
                Settings.getInstance().getHeight())
        ) {
            Random random = Settings.getInstance().getRandomGenerator();
            ShapeFactory shapeFactory = new ShapeFactory();

            Map<String, Integer> oneShapeOneCount = Settings.getInstance().getShapesWithCount();
            oneShapeOneCount.forEach((key, value) -> {

                String figureName = key;
                String figureNameDescription = Settings.getInstance().getShapeDescription(figureName);
                try {
                    Shape figureShape = shapeFactory.create(figureNameDescription);
                    for (int i = 0; i < value; i++) {
                        PositionedShape f = new PositionedShape(figureShape, random.nextInt(400), random.nextInt(400));
                        f.draw(svg);
                    }
                } catch (Exception e) {
                    System.out.println("ошибка");
                }
            });

        } catch (Exception e) {
            System.out.println("ошибка записи");
        }
        return "nothing there";
    }
}
