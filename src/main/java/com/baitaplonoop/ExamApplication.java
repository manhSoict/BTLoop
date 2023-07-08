package com.baitaplonoop;

import com.managers.WindowManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WindowManager wm = WindowManager.getInstance(); // pass primary stage to WM
        wm.setMainWindow(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 926, 520);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}