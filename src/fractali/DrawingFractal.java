package fractali;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingFractal extends Application {
    //ix = x' в конспекте, iy = y' в конспекте
    private double x0 = -2; // у нас математические координаты, поле от -2 до 2, круг от -1 до 1
    private double y0 = 2; // но нужно понять, сколько нужно пикселей и как переходить, допустим, хотим, чтобы поле
    private double dx = 0.01; // рисовалось 400х400 пикселей. тогда в одной единице поля 100х100 пикселей, т.е.
                                //1 пиксель - 0,01 поля
    private int WIDTH = 400;
    private int HEIGHT = 400;

    private Fractal fractal = new FractalCircleGrayGradient();
    private Palette palette = new PaletteGrayGradient();

    private HBox root = new HBox();
    private ImageView fullImage = new ImageView();
    private WritableImage wiImageWithFractal = new WritableImage(WIDTH, HEIGHT);
    private PixelWriter pixelWriterForImageWithFractal = wiImageWithFractal.getPixelWriter();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Фракталы");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        fullImage.setImage(wiImageWithFractal);
        root.getChildren().addAll(fullImage);
        return root;
    }

    private void initInteraction() {
        //перебрать все пиксели
        for (int ix = 0; ix < WIDTH - 1; ix++) {
            for (int iy = 0; iy < HEIGHT - 1; iy++) {
                double x = x0 + ix * dx;
                double y = y0 - iy * dx;
                double colorInd = fractal.getColor(x, y);
                Color color = palette.getColor(colorInd);
                pixelWriterForImageWithFractal.setColor(ix, iy, color);
            }

        }

    }

}
