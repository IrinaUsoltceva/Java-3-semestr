package fractali;

public class FractalMandelbrot implements Fractal {

    private int N = 500;
    private double R = 100000;

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
            double z2 = x * x + y * y;
            if (z2 < R * R) {
                double x1 = x * x - y * y + p;
                double y1 = 2 * x * y + q;
                x = x1;
                y = y1;
                k++;
            } else {
                double fix =  Math.log(Math.log(z2) / 2 / Math.log(R)) / Math.log(2);
                return (k - fix) / N;
            }

        }

        return 1;
    }
}
