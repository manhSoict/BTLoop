package com.baitaplonoop;

import com.entities.Category;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Category defaultCtg = new Category("Default");
        Category math = new Category("Math");
        math.setTreeLevel(3);
        defaultCtg.getChildren().add(math);
        try (FileOutputStream fos = new FileOutputStream("category.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
                oos.writeObject(defaultCtg);
        } catch (IOException i) {
            i.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai1.fxml"));
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