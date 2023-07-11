package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.baitaplonoop.ExamApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    public Label LabelQuizname,LabelQuizname1,LabelAdd,LabelSave,LabelFrom;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        AnchorSelect.setVisible(false); // ẩn panel PanelQS ban đầu
        LabelQuizname.setText(ExamApplication.getNewQuiz());
        LabelQuizname1.setText(ExamApplication.getNewQuiz());
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