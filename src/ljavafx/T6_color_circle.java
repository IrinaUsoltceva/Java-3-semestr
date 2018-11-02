package ljavafx;

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
    private HBox root = new HBox();

    private Slider radius = new Slider(10, 200, 100);
    private ColorPicker fonColor = new ColorPicker();
    private ColorPicker circleColor = new ColorPicker();
    private Label fonLabel = new Label("цвет фона");
    private Label circleLabel = new Label("цвет круга");
    private Label radiusLabel = new Label("размер круга");

    private Circle circle = new Circle(90, 90, 90);


    private Pane fon = new Pane(circle);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("circle");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();
        primaryStage.show();

        radius.setMin(10);
        radius.setValue((radius.getMin() + radius.getMax()) / 2);
    }

    private Parent initInterface() {

        VBox manager = new VBox(radiusLabel, radius, circleLabel, circleColor, fonLabel, fonColor);
        manager.setPrefWidth(300);

        root.getChildren().addAll(manager, fon);
        root.setPrefSize(800, 500);
        HBox.setHgrow(fon, Priority.ALWAYS);

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

        radius.maxProperty().bind(
                Bindings.createDoubleBinding(
                        () -> {
                            if (fon.getHeight() < fon.getWidth())
                                return fon.getHeight() / 2;
                            else
                                return fon.getWidth() / 2;
                        },
                        fon.heightProperty(),
                        fon.widthProperty()
                )
        );

//        radius.minProperty().bind(
//                Bindings.min(Bindings.add(radius.maxProperty(), - 1), 10)
//        );
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
