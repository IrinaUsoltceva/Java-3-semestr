package fractali;

public class FractalMandelbrot implements Fractal {
    @Override
    public double getColor(double x, double y) {
        //c = p + i * q
        //z_0 = 0
        //z_n+1 = z_n^2 + c
        //сделать N=1000 итераций. На той итерации, когда |z_k| > R = 1e9
        // вернуть k / N
        double p = x;
        double q = y;

        double N = 100;
        int k = 0;
        for (int i = 0; i < 100; i++) {
            if (Math.sqrt(x * x + y * y) < N) {
                double x1 = x * x - y * y + p;
                double y1 = 2 * x * y + q;
                x = x1;
                y = y1;
                k++;
            }
            else {
                double index = k / N;
                return index;
            }

        }

        return 1;
    }
}
