package fractali;

import javafx.scene.paint.Color;

public class PaletteGrayGradientLittlePieces  implements Palette {
    @Override
    public Color getColor(double ind) {
        for (int i = 0; i <= 5 ; i ++) {
            if (2 * i < ind * 10 && ind * 10 < 2 * i + 1)
                return Color.gray(ind);
            else
                return Color.gray((ind - 1) * (-1));
        }
        return Color.gray(ind);
    }
}