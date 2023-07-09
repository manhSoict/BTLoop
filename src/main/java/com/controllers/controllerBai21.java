package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.entities.Category;
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
import javafx.util.StringConverter;

public class controllerBai21 implements Initializable {
	@FXML
	public ComboBox<Category> comboBox;
	@FXML
	public Label creatnewquestion;
	@FXML
	private CheckBox showQuestion;
	@FXML
	private ScrollPane panelQuestion;
	@FXML
	private TableView<Question> questionTable;


	ObservableList<Category> list = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list.add(new Category("Default"));
		Category math = new Category("Math");
		math.setTreeLevel(1);
		list.add(math);
		comboBox.setConverter(new StringConverter<Category>() {
			@Override
			public String toString(Category category) {
				return category.getName();
			}

			@Override
			public Category fromString(String s) {
				return null;
			}
		});
		comboBox.setCellFactory(
				new Callback<ListView<Category>, ListCell<Category>>() {
					@Override public ListCell<Category> call(ListView<Category> param) {
						final ListCell<Category> cell = new ListCell<Category>() {
							{
								super.setPrefWidth(100);
							}
							@Override public void updateItem(Category item,
															 boolean empty) {
								super.updateItem(item, empty);
								if (item != null) {
									String itemString = "";
									for(int i = 0; i < item.getTreeLevel(); ++i) {
										itemString += " ";
									}
									setText(itemString + item.getName());
								}
								else {
									setText(null);
								}
							}
						};
						return cell;
					}
				});
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai22.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
