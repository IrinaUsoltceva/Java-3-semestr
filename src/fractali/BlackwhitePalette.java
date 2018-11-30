package fractali;

import javafx.scene.paint.Color;

class BlackwhitePalette implements Palette {
    @Override
    public Color getColor(double ind) {
        if (ind < 0.5)
            return Color.BLACK;
        else
            return Color.WHITE;
    }

    //будет палитр меньше половинки - черная, больша -  белая.      самим - градиент
}
