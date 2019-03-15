package fractali;

import javafx.scene.paint.Color;

public class PaletteGrayGradientReverse implements Palette {
    @Override
    public Color getColor(double ind) {

        return Color.gray((ind - 1) * (-1));
    }
}