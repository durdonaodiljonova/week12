package org.example;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SimpleCalc extends Application{
    private double sum=0;

    public void start(Stage stage){
        Label label1=new Label("Number 1:");
        Label label2=new Label("Number 2:");
        Label result=new Label("Result:");

        TextField num1Field=new TextField();
        TextField num2=new TextField();
        TextField results=new TextField();
        results.setPadding(new Insets(10));

        Button calcBtn=new Button("Calculate");
        Button clearBtn=new Button("CLear");

        calcBtn.setOnAction(e ->{
            try{

                double n1=Double.parseDouble(num1Field.getText());
                double n2=Double.parseDouble(num2.getText());
                double sum=n1+n2;
                results.setText(String.format("Sum: %.2f", sum));
            } catch(NumberFormatException ex){
                results.setText("invalid input");
            }
        });

        clearBtn.setOnAction(e -> {
            num1Field.clear();
            num2.clear();
            results.clear();
        });


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);


        grid.add(label1, 0, 0);
        grid.add(num1Field, 1, 0);

        grid.add(label2, 0, 1);
        grid.add(num2, 1, 1);

        grid.add(calcBtn, 2, 4);
        grid.add(clearBtn, 2, 5);

        grid.add(result, 0, 2);

        Scene scene = new Scene(grid, 350, 250);

        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    }
