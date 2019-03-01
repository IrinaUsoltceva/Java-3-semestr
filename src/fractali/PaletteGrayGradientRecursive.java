package fractali;

import javafx.scene.paint.Color;

public class PaletteGrayGradientRecursive implements Palette {
    @Override
    public Color getColor(double ind) {
        double recursiveInd = -1;

        int degree = 0;
        int N = 1024;

        while (N > 1) {
            //System.out.println("\t" + N);
            if (Math.pow(1.0/2, degree + 1) <= ind && ind < Math.pow(1.0/2, degree)) {
                recursiveInd = ind * Math.pow(2, degree + 1) - 1;
                return Color.gray(recursiveInd);
            }
            else {
                degree++;
                N = N / 2;
            }
        }

        if (ind == 1)
            return Color.gray(1);

        return Color.gray(0);
    }
}
