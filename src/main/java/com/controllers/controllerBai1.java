package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class controllerBai1 {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	
    @FXML
    private AnchorPane PanelQS;
    @FXML
    public Label turnedittingon;
    @FXML
    public Label setting;
    public void initialize() {
        PanelQS.setVisible(false); // ẩn panel PanelQS ban đầu
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

}