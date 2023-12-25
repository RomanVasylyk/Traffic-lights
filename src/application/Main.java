package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Timeline;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Semafor sm = new Semafor(0,0);
        Button bt = new Button("auto");
        Button bt1 = new Button("manu");
        bt.setOnAction(e -> sm.auto());
        bt1.setOnAction(e -> sm.manu());
        
        HBox h = new HBox();
        BorderPane root = new BorderPane();
        h.getChildren().addAll(bt, bt1);
        
        root.setBottom(h);
        root.getChildren().addAll(sm);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
