package com.baitaplonoop;

import com.managers.SceneManager;
import com.managers.WindowManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai21.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
//        new SceneManager(stage).switchScene("hello-view.fxml");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}