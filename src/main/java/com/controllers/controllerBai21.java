package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

public class controllerBai21 implements Initializable{
	@FXML
	public ComboBox<String> comboBox;
	@FXML
	public Label Categories;
	@FXML
	private CheckBox showQuestion;
	@FXML
	private ScrollPane panelQuestion;
	
	ObservableList<String> list = FXCollections.observableArrayList("1","2","3");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(list);
		panelQuestion.setVisible(false);
	}
	@FXML
	public void showpanelQuestion() {
		if (comboBox.getValue() != null && showQuestion.isSelected()) {
	        panelQuestion.setVisible(true);
	    } else {
	        panelQuestion.setVisible(false);
	    }
	}
	    @FXML
    public void openBai22(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bai22.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
