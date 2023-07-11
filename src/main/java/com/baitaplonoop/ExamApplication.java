package com.baitaplonoop;

import com.entities.Category;
import com.entities.Question;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class ExamApplication extends Application {

    private static Category defaultCategory;
    public static Category getDefaultCategory() {
        return defaultCategory;
    }

    private static Question editingQuestion;
    public static void setEditingQuestion(Question question) {
        editingQuestion = question;
    }
    public static Question getEditingQuestion() {
        return editingQuestion;
    }
    @Override
    public void start(Stage stage) throws IOException {
        try (FileInputStream fos = new FileInputStream("category.txt");
             ObjectInputStream oos = new ObjectInputStream(fos); ) {
            defaultCategory = (Category) oos.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(defaultCategory == null) {
            Category defaultCtg = new Category("Default");
            try (FileOutputStream fos = new FileOutputStream("category.txt");
                 ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
                oos.writeObject(defaultCtg);
            } catch (IOException i) {
                i.printStackTrace();
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai21.fxml"));
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

    public static void SaveData() {
        try (FileOutputStream fos = new FileOutputStream("category.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
            oos.writeObject(defaultCategory);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}