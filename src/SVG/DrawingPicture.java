package SVG;

import java.util.Map;
import java.util.Random;

public class DrawingPicture {
    public static void main(String[] args) {
        try (SVG svg = new SVG("a.svg",
                Settings.getInstance().getWidth(),
                Settings.getInstance().getHeight())
        ) {
            Random random = Settings.getInstance().getRandomGenerator();

            ShapeFactory shapeFactory = new ShapeFactory();
            String figureName = "small_square";
            //String figureName = "red_circle";
            String figureNameDescription = Settings.getInstance().getShapeDescription(figureName);
            Shape figureShape = shapeFactory.create(figureNameDescription);

            for (int i = 0; i < 1000; i++) {
                PositionedShape f = new PositionedShape(new SmallSquare(), random.nextInt(400), random.nextInt(400));
                //PositionedShape f = new PositionedShape(figureShape, random.nextInt(400), random.nextInt(400));

                PositionedShape f2 = new PositionedShape(new RedCircle(), random.nextInt(400), random.nextInt(400));
                //PositionedShape f2 = new PositionedShape(figureShape, random.nextInt(400), random.nextInt(400));

                f2.draw(svg);
                f.draw(svg);
            }

            for (int i = 0; i < 500; i++) {
                PositionedShape f = new PositionedShape(new RedCircle(), random.nextInt(400), random.nextInt(400));
                f.draw(svg);
            }

            Map<String, Integer> oneShapeOneCount = Settings.getInstance().getShapesWithCount();
            oneShapeOneCount.forEach((key, value) -> System.out.println(key + " -> " + value));

        } catch (Exception e) {
            System.out.println("ошибка записи");
        }

    }
}
