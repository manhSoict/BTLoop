package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.entities.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class controllerBai21 implements Initializable {
	@FXML
	public ComboBox<String> comboBox;
	@FXML
	public Label creatnewquestion;
	@FXML
	private CheckBox showQuestion;
	@FXML
	private ScrollPane panelQuestion;
	@FXML
	private TableView<Question> questionTable;

	
	ObservableList<String> list = FXCollections.observableArrayList("Default","   IT","  Math");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		comboBox.setCellFactory(
//				new Callback<ListView<String>, ListCell<String>>() {
//					@Override public ListCell<String> call(ListView<String> param) {
//						final ListCell<String> cell = new ListCell<String>() {
//							{
//								super.setPrefWidth(100);
//							}
//							@Override public void updateItem(String item,
//															 boolean empty) {
//								super.updateItem(item, empty);
//								if (item != null) {
//									setText(item);
//									if (item.contains("High")) {
//										setTextFill(Color.RED);
//									}
//									else if (item.contains("Low")){
//										setTextFill(Color.GREEN);
//									}
//									else {
//										setTextFill(Color.BLACK);
//									}
//								}
//								else {
//									setText(null);
//								}
//							}
//						};
//						return cell;
//					}
//				});
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
    public void openBai32(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai32.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
