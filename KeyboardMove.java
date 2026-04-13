package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KeyboardMove extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(500, 400);

        Rectangle rect = new Rectangle(220, 180, 60, 40);
        rect.setFill(Color.BLUE);

        TextField position = new TextField("X: 220 Y: 180");
        position.setEditable(false);

        Scene scene = new Scene(new BorderPane(pane, null, null, position, null), 500, 420);

        scene.setOnKeyPressed(e -> {
            double x = rect.getX();
            double y = rect.getY();

            if (e.getCode() == KeyCode.UP) y -= 10;
            if (e.getCode() == KeyCode.DOWN) y += 10;
            if (e.getCode() == KeyCode.LEFT) x -= 10;
            if (e.getCode() == KeyCode.RIGHT) x += 10;

            // Clamp
            x = Math.max(0, Math.min(x, 500 - 60));
            y = Math.max(0, Math.min(y, 400 - 40));

            rect.setX(x);
            rect.setY(y);

            position.setText("X: " + (int)x + " Y: " + (int)y);
        });

        pane.getChildren().add(rect);

        scene.getRoot().requestFocus();

        stage.setScene(scene);
        stage.setTitle("Keyboard Move");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}