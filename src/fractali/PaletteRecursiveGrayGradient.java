package fractali;

import javafx.scene.paint.Color;

public class PaletteRecursiveGrayGradient implements Palette {
    @Override
    public Color getColor(double ind) {

        double recursiveInd;

        int degree = 0;
        int N = 1024;

        while (N > 1) {
            if (Math.pow(1/2, degree + 1) <= ind && ind < Math.pow(1/2, degree)) {
                recursiveInd = ind * Math.pow(1/2, degree + 1);
                System.out.println(recursiveInd);
                return Color.gray(recursiveInd);

            }
            else {
                degree++;
                N = N / 2;
            }
        }

        return Color.gray(ind);
    }
}
