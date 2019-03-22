package fractali;

import javafx.scene.paint.Color;

public class PaletteGrayGradientLittlePiecesReverse implements Palette {
    @Override
    public Color getColor(double ind) {
        for (int i = 0; i <= 5 ; i ++) {
            double j = 2 * i;
            if (j / 10 <= ind && ind < (j + 1) / 10)
                return Color.gray((ind - j / 10) * 10);

            if ((j + 1) / 10 <= ind && ind < (j + 2) / 10)
                return Color.gray(((ind - 0.1 - j / 10) * 10 - 1) * (-1));
        }
        return Color.gray(ind);
    }
}