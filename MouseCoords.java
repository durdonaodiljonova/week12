package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MouseCoords extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Move the mouse over the pane");

        StackPane pane = new StackPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: lightblue;");

        pane.setOnMouseMoved(e ->
                label.setText(String.format("X: %.1f Y: %.1f", e.getX(), e.getY()))
        );

        pane.setOnMouseClicked(e -> {
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
            pane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b));
        });

        pane.setOnMouseExited(e ->
                label.setText("Move the mouse over the pane")
        );

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(label);

        stage.setScene(new Scene(root, 400, 320));
        stage.setTitle("Mouse Coordinates");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}