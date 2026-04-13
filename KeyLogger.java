package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {

    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        TextArea log = new TextArea();
        log.setEditable(false);
        log.setPrefRowCount(5);

        Button clearBtn = new Button("Clear Log");

        input.setOnKeyPressed(e ->
                log.appendText("PRESSED | Code: " + e.getCode()
                        + " | Shift: " + e.isShiftDown()
                        + " | Ctrl: " + e.isControlDown() + "\n")
        );

        input.setOnKeyReleased(e ->
                log.appendText("RELEASED | Code: " + e.getCode() + "\n")
        );

        input.setOnKeyTyped(e ->
                log.appendText("TYPED | Char: " + e.getCharacter() + "\n")
        );

        clearBtn.setOnAction(e -> log.clear());

        VBox root = new VBox(10, input, log, clearBtn);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 420, 320));
        stage.setTitle("Key Logger");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}