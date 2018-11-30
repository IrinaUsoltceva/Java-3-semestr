package fractali;

public class FractalCircleSqGrayGradient implements Fractal {
    @Override
    public double getColor(double x, double y) {
        double d = x * x + y * y;
        if (d < 1)
            return d;
        else
            return 1;
    }
}
