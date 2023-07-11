package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.baitaplonoop.ExamApplication;
import com.entities.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class controllerBai62 implements Initializable{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    public AnchorPane AnchorSelect;
    @FXML
    public Label LabelQuizname,LabelQuizname1,LabelAdd,LabelSave,LabelFrom, totalMarks;

    @FXML
    TableView<Question> questionTable;
    @FXML
    TableColumn<Question, String> markColumn, questionColumn;

    ObservableList<Question> selectedQuestions = FXCollections.observableArrayList();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        AnchorSelect.setVisible(false); // ẩn panel PanelQS ban đầu
        LabelQuizname.setText(ExamApplication.getNewQuiz());
        LabelQuizname1.setText(ExamApplication.getNewQuiz());
        for (Question question : ExamApplication.getQuizQuestions()) {
            selectedQuestions.add(question);
        }

        questionColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getQuestion()));
        markColumn.setCellValueFactory(p -> new SimpleStringProperty("1.00"));
        questionTable.setItems( selectedQuestions);
        totalMarks.setText(selectedQuestions.size() + ".00");
    }

    @FXML
    public void AppearOrHide() {
        if (AnchorSelect.isVisible()) {
            AnchorSelect.setVisible(false); // ẩn panel PanelQS nếu nó đang hiển thị
        } else {
            AnchorSelect.setVisible(true); // hiển thị panel PanelQS nếu nó đang ẩn
        }
    }

    @FXML
    public void openBai61(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai61.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void openBai63(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai63.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}