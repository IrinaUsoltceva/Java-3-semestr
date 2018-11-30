package fractali;

public class FractalCircleGrayGradient implements Fractal {
    @Override
    public double getColor(double x, double y) {
        double d = Math.sqrt(x * x + y * y);
        if (d < 1)
            return d;
        else
            return 1;
    }
}
