package LJavafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
        return root;
    }

    private void initInteraction() {
        circle.fillProperty().bind(circleColor.valueProperty());

        circle.radiusProperty().bind(radius.valueProperty());

        fonColor.valueProperty().addListener(
                prop -> fon.setStyle("-fx-background-color: #" + fonColor.valueProperty().get().toString().substring(2, 8))
        );

        circle.centerXProperty().setValue(fon.getWidth() / 2);
        circle.centerYProperty().setValue(fon.getHeight() / 2);


    }
}
