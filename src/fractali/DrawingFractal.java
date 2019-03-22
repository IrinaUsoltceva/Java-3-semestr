package fractali;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    private Palette palette = new PaletteGrayGradientLittlePieces();

    private Pane root = new Pane();
    private ImageView fullImage = new ImageView();

    private Task<WritableImage> task = null;

    private FileChooser fileChooser = new FileChooser();

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
        createFractalImage(WIDTH, HEIGHT);
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

       if (keyCode == EQUALS || keyCode == ADD) {
           double dx1 = dx / 1.5;
           x0 += root.getWidth()/2 * (dx - dx1);
           y0 -= root.getHeight()/2 * (dx - dx1);
           dx = dx1;
           updateImage();
       }
        if (keyCode == MINUS || keyCode == SUBTRACT) {
            double dx1 = dx * 1.5;
            x0 += root.getWidth()/2 * (dx - dx1);
            y0 -= root.getHeight()/2 * (dx - dx1);
            dx = dx1;
            updateImage();
        }

        if (keyCode == C) {
           saveImage();
        }
    }

    private void updateImage() {
        if (root.getWidth() != 0 && root.getHeight() != 0)
            createFractalImage((int) root.getWidth(), (int) root.getHeight());
    }

    private void saveImage() {
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showSaveDialog(primaryStage);
        if (selectedFile != null) {
            File outputFile = new File(selectedFile.getPath());
            BufferedImage bImage = SwingFXUtils.fromFXImage(fullImage.getImage(), null);
            try {
                ImageIO.write(bImage, "png", outputFile);
            } catch (IOException e) {
                System.out.println("ошибка");
            }
        }
    }

    private void loadPlace() {}

    private void createFractalImage(int width, int height) {
        if (task != null)
            task.cancel();

         task = new Task<WritableImage>() {

            @Override
            protected WritableImage call() throws Exception {

                WritableImage wiImageWithFractal = new WritableImage(width, height);
                PixelWriter pixelWriterForImageWithFractal = wiImageWithFractal.getPixelWriter();

                for (int iy = 0; iy < height - 1; iy++){
                    for  (int ix = 0; ix < width - 1; ix++) {
                        double x = x0 + ix * dx;
                        double y = y0 - iy * dx;
                        double colorInd = fractal.getColor(x, y);
                        Color color = palette.getColor(colorInd);
                        pixelWriterForImageWithFractal.setColor(ix, iy, color);
                    }
                    updateValue(
                            copyImage(wiImageWithFractal)
                    );
                    if (isCancelled()) return null;
                }
                return wiImageWithFractal;
            }
        };

        new Thread(task).start();

        task.valueProperty().addListener(e ->
            fullImage.setImage(task.getValue())
        );

        task.onSucceededProperty().addListener(e ->
            this.task = null
        );


    }

    private WritableImage copyImage(Image image) {
        int height=(int)image.getHeight();
        int width=(int)image.getWidth();
        PixelReader pixelReader=image.getPixelReader();
        WritableImage writableImage = new WritableImage(width,height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                Color color = pixelReader.getColor(x, y);
                pixelWriter.setColor(x, y, color);
            }
        }
        return writableImage;
    }

}
