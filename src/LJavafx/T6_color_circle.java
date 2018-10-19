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

    FlowPane root = new FlowPane();

    Slider radius = new Slider(1, 100, 10);
    ColorPicker fonColor = new ColorPicker();
    ColorPicker circleColor = new ColorPicker();

    Circle circle = new Circle(90, 90, 90);
    Pane fon = new Pane(circle);

    private Parent initInterface() {

        VBox manager = new VBox(radius, circleColor, fonColor);
        manager.setPrefWidth(300);

        root.getChildren().addAll(manager, fon);
        root.setPrefWidth(600);
        return root;
    }

    private void initInteraction() {
        circle.fillProperty().bind(circleColor.valueProperty());

    }
}
