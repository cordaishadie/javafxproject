package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Instantiate a VBox root mode
        VBox root = new VBox();

        // instantiate a Meal object
        Meal meal = new Meal();

        // instantiate a MealPane object and add it to the root
        root.getChildren().add(new MealPane(meal));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}