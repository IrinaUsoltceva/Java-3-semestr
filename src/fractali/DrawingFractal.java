package fractali;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.*;

public class DrawingFractal extends Application {
    //ix = x' в конспекте, iy = y' в конспекте
    private double x0 = -2; // у нас математические координаты, поле от -2 до 2, круг от -1 до 1
    private double y0 = 2; // но нужно понять, сколько нужно пикселей и как переходить, допустим, хотим, чтобы поле
    private double dx = 0.01; // рисовалось 400х400 пикселей. тогда в одной единице поля 100х100 пикселей, т.е.
    //1 пиксель - 0,01 поля
    private int WIDTH = 400;
    private int HEIGHT = 400;

    private int sdvig = 50;

    private Fractal fractal = new FractalMandelbrot();
    private Palette palette = new PaletteGrayGradient();

    private Pane root = new Pane();
    private ImageView fullImage = new ImageView(createFractalImage(WIDTH, HEIGHT));

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Фракталы");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));

        initInteraction();
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->
                    changePlace(event.getCode())
        );
    }

    private Parent initInterface() {
        root.getChildren().addAll(fullImage);
        return root;
    }

    private void initInteraction() {
        root.widthProperty().addListener(
                prop -> updateImage()
        );

        root.heightProperty().addListener(
                prop -> updateImage()
        );
    }

    private void changePlace(KeyCode keyCode) {
       if (keyCode == UP) {
           y0 += sdvig * dx;
           updateImage();
       }

        if (keyCode == DOWN) {
            y0 -= sdvig * dx;
            updateImage();
        }

        if (keyCode == LEFT) {
            x0 -= sdvig * dx;
            updateImage();
        }

        if (keyCode == RIGHT) {
            x0 += sdvig * dx;
            updateImage();
        }
    }

    private void updateImage() {
        if (root.getWidth() != 0 && root.getHeight() != 0)
            fullImage.setImage(createFractalImage((int) root.getWidth(), (int) root.getHeight()));
    }

    private Image createFractalImage(int width, int height) {

        WritableImage wiImageWithFractal = new WritableImage(width, height);
        PixelWriter pixelWriterForImageWithFractal = wiImageWithFractal.getPixelWriter();

        //перебрать все пиксели
        for (int ix = 0; ix < width - 1; ix++) {
            for (int iy = 0; iy < height - 1; iy++) {
                double x = x0 + ix * dx;
                double y = y0 - iy * dx;
                double colorInd = fractal.getColor(x, y);
                Color color = palette.getColor(colorInd);
                pixelWriterForImageWithFractal.setColor(ix, iy, color);
            }

        }


        return wiImageWithFractal;
    }

}
