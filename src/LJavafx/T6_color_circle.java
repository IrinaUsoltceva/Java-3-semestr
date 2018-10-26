package LJavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;

public class T6_color_circle extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("circle");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();
        primaryStage.show();
    }

    private FlowPane root = new FlowPane();

    private Slider radius = new Slider(10, 200, 100);
    private ColorPicker fonColor = new ColorPicker();
    private ColorPicker circleColor = new ColorPicker();
    private Label fonLabel = new Label("цвет фона");
    private Label circleLabel = new Label("цвет круга");

    private Circle circle = new Circle(90, 90, 90);
    private Pane fon = new Pane(circle);

    private Parent initInterface() {

        VBox manager = new VBox(radius, circleLabel, circleColor, fonLabel, fonColor);
        manager.setPrefWidth(300);

        root.getChildren().addAll(manager, fon);
        root.setPrefWidth(600);

        /*
        VBox manager = new VBox(radius, circleLabel, circleColor, fonLabel, fonColor);
        manager.setPrefWidth(300);

        VBox fonAndCircle = new VBox(fon);

        //fon.setMinSize(100,100);
        //fon.setMaxSize(600,600);

        VBox.setVgrow(fon, Priority.ALWAYS);

        root.getChildren().addAll(manager, fonAndCircle);
        root.setPrefWidth(600);
         */
        return root;
    }

    private void initInteraction() {
        circle.fillProperty().bind(circleColor.valueProperty());

        circle.radiusProperty().bind(radius.valueProperty());

        fon.backgroundProperty().bind(
                Bindings.createObjectBinding(
                    () -> new Background(
                            new BackgroundFill(
                                    Color.web(toRGBCode(fonColor.getValue())),
                                    new CornerRadii(0), //радиус закругления углов
                                    Insets.EMPTY //пустой отступ для закраски
                            )
                    ),
                    fonColor.valueProperty()
                )
        );

        /*fon.styleProperty().bind(
                Bindings.createStringBinding(
                        () -> "-fx-background-color: " + toRGBCode(fonColor.getValue()),
                        fonColor.valueProperty()
                )
        );*/

        circle.centerXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> fon.getWidth() / 2,
                        fon.widthProperty()
                )
        );

        circle.centerYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> fon.getHeight() / 2,
                        fon.heightProperty()
                )
        );

        //circle.centerXProperty().setValue(fon.getWidth() / 2); //нужно через биндинги
        //circle.centerYProperty().setValue(fon.getHeight() / 2);


    }

    private static String toRGBCode(Color color) {
        String col = String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
        System.out.println("to rgb: " + col);

        return col;
    }
}
