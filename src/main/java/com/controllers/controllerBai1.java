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


public class controllerBai1 implements Initializable{
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	
    @FXML
    private AnchorPane PanelQS;
    @FXML
    public Label turnedittingon,LabelQuestions,LabelCategories,LabelImport, LabelQuiz;
    @FXML
    public Label setting;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        PanelQS.setVisible(false); // ẩn panel PanelQS ban đầu
        if (ExamApplication.getNewQuiz().equals("")) {
            LabelQuiz.setVisible(false);
        } else {
            LabelQuiz.setVisible(true);
            LabelQuiz.setText(ExamApplication.getNewQuiz());
        }
    }
	
    @FXML
    public void AppearOrHide() {
        if (PanelQS.isVisible()) {
            PanelQS.setVisible(false); // ẩn panel PanelQS nếu nó đang hiển thị
        } else {
            PanelQS.setVisible(true); // hiển thị panel PanelQS nếu nó đang ẩn
        }
    }
    
    @FXML
    public void openBai21(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai21.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void openBai5(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai5.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void openBai33(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai33.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void openBai34(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai34.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void openBai61(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai61.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}