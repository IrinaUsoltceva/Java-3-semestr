package fractali;

public class FractalMandelbrot implements Fractal {

    private int N = 1024;
    private double R = 1000;

    //int N = 100; //TODO move to constructor
    //double R = 100;  //TODO move to constructor

    @Override
    public double getColor(double x, double y) {
        //c = p + i * q
        //z_0 = 0
        //z_n+1 = z_n^2 + c
        //сделать N=1000 итераций. На той итерации, когда |z_k| > R = 1e9
        // вернуть k / N

        double p = x;
        double q = y;

        int k = 0;
        for (int i = 0; i < N; i++) {
            if (x * x + y * y < R * R) {
                double x1 = x * x - y * y + p;
                double y1 = 2 * x * y + q;
                x = x1;
                y = y1;
                k++;
            }
            else {
                return (double)k / N;
            }

        }

        return 1;
    }
}
