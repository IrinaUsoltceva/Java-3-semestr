package SVG;

public class ShapeFactory {

    public Shape create (String figureName) throws Exception {
        Class<?> clas = Class.forName(figureName);
        Shape shape = (Shape) clas.newInstance();
        return shape;
    }
}
