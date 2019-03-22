package fractali;

import javafx.scene.paint.Color;

public class PaletteColor implements Palette {
    @Override
    public Color getColor(double ind) {

        return Color.hsb(ind * 360, 0.9,0.9);
    }
}