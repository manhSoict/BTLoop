package com.baitaplonoop;

import com.managers.SceneManager;
import com.managers.WindowManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai32.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent, 926, 520);
        stage.setTitle("Hello!");
//        stage.setUserData();
        stage.setScene(scene);
//        new SceneManager(stage).switchScene("hello-view.fxml");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}