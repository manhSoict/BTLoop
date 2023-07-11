package com.baitaplonoop;

import com.entities.Category;
import com.entities.Question;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExamApplication extends Application {

    public static String getNewQuiz() {
        return newQuiz;
    }

    public static void setNewQuiz(String newQuiz) {
        ExamApplication.newQuiz = newQuiz;
    }

    private static String newQuiz = "";
    private static List<Question> quizQuestions = new ArrayList<>();

    public static List<Question> getQuizQuestions() {
        return quizQuestions;
    }

    public static void setQuizQuestions(List<Question> quizQuestions) {
        ExamApplication.quizQuestions = quizQuestions;
    }

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

        FXMLLoader fxmlLoader = new FXMLLoader(ExamApplication.class.getResource("Bai74.fxml"));
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

    public static void ExportQuizQuestionToPDF() {
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(FILE));
//            document.open();
//            addMetaData(document);
//            addTitlePage(document);
//            addContent(document);
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}