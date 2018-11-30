package fractali;

import javafx.scene.paint.Color;

public class PaletteGrayGradient implements Palette {
    @Override
    public Color getColor(double ind) {
        return Color.gray(ind);
    }
}