package fractali;

public class FractalMandelbrot implements Fractal {
    @Override
    public double getColor(double x, double y) {
        //c = x + i * y
        //z_0 = 0
        //z_n+1 = z_n^2 + c
        //сделать N=1000 итераций. На той итерации, когда |z_k| > R = 1e9
        // вернуть k / N
    }
}
