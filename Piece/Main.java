package Piece;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    EchequierUI echiquierUI = new EchequierUI();
    StackPane root = new StackPane();
    root.getChildren().add(echiquierUI);

    Scene scene = new Scene(root, 600, 600);
    primaryStage.setTitle("Jeu d'Échecs");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {

    launch(args);
  }
}
