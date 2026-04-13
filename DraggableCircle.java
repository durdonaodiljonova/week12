package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {

    private double offsetX, offsetY;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(500, 400);

        Circle circle = new Circle(250, 200, 40, Color.CORAL);

        circle.setOnMousePressed(e -> {
            offsetX = e.getSceneX() - circle.getCenterX();
            offsetY = e.getSceneY() - circle.getCenterY();
        });

        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getSceneX() - offsetX);
            circle.setCenterY(e.getSceneY() - offsetY);
            circle.setFill(Color.TOMATO);
        });

        circle.setOnMouseReleased(e ->
                circle.setFill(Color.CORAL)
        );

        pane.getChildren().add(circle);

        stage.setScene(new Scene(pane, 500, 400));
        stage.setTitle("Draggable Circle");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}