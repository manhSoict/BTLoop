package com.controllers;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.baitaplonoop.ExamApplication;
import com.entities.Category;
import com.entities.Question;
import com.tableEntities.QuestionRow;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class controllerBai21 implements Initializable {
	@FXML
	public ComboBox<Category> comboBox;
	@FXML
	public Label creatnewquestion,LabelCategories,LabelImport,LabelIT;
	@FXML
	private CheckBox showQuestion;
	@FXML
	private ScrollPane panelQuestion;
	@FXML
	private TableView<Question> questionTable;
	@FXML
	private TableColumn<Question, String> questionColumn;
	@FXML
	private TableColumn<Question, String> questionNameColumn;

	ObservableList<Category> categories = FXCollections.observableArrayList();
	ObservableList<Question> questions = FXCollections.observableArrayList();

	void getAllCategories(Category root) {
		categories.add(root);
		for (Category category: root.getChildren()) {
			getAllCategories(category);
		}
	}

	void getQuestions(Category root) {
		questions.addAll(root.getQuestions());
		for (Category category: root.getChildren()) {
			getQuestions(category);
		}
//		questions.add(new QuestionRow("asfd "));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Category defaultCtg = ExamApplication.getDefaultCategory();
		getAllCategories(defaultCtg);
		getQuestions(defaultCtg);
		comboBox.setConverter(new StringConverter<Category>() {
			@Override
			public String toString(Category category) {
				return category.getName() + category.totalQuestionsString();
			}

			@Override
			public Category fromString(String s) {
				return null;
			}
		});
		comboBox.setCellFactory(
				new Callback<ListView<Category>, ListCell<Category>>() {
					@Override public ListCell<Category> call(ListView<Category> param) {
						final ListCell<Category> cell = new ListCell<>() {
							{
								super.setPrefWidth(100);
							}

							@Override public void updateItem(Category item,
															 boolean empty) {
								super.updateItem(item, empty);
								if (item != null) {
									String itemString = "";
									for(int i = 0; i < item.getTreeLevel(); ++i) {
										itemString += "  ";
									}
									setText(itemString + item.getName() + item.totalQuestionsString());
								} else {
									setText(null);
								}
							}
						};
						return cell;
					}
				});
		comboBox.setItems(categories);
		comboBox.setValue(categories.get(0));
		panelQuestion.setVisible(false);
		questionColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getQuestion()));
		questionNameColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getQuestionName()));
		addButtonToTable();
		questionTable.setItems(questions);
	}

	@FXML
	public void onChangeCategory(ActionEvent event) {
		questions.clear();
		getQuestions(comboBox.getValue());
	}

	@FXML
	public void showpanelQuestion() {
		if (comboBox.getValue() != null && showQuestion.isSelected()) {
			panelQuestion.setVisible(true);
		} else {
			panelQuestion.setVisible(false);
		}
	}

	private void addButtonToTable() {
		TableColumn<Question, Void> colBtn = new TableColumn("Action");

		Callback<TableColumn<Question, Void>, TableCell<Question, Void>> cellFactory = new Callback<TableColumn<Question, Void>, TableCell<Question, Void>>() {
			@Override
			public TableCell<Question, Void> call(final TableColumn<Question, Void> param) {
				final TableCell<Question, Void> cell = new TableCell<Question, Void>() {

					private final Button btn = new Button("Edit");

					{
						btn.setOnAction((ActionEvent event) -> {
							Question data = getTableView().getItems().get(getIndex());
							ExamApplication.setEditingQuestion(data);
							System.out.println("selectedData: " + data.getQuestionName());
							try {
								openBai32b(event);
							} catch (IOException e) {
								throw new RuntimeException(e);
							}
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

		questionTable.getColumns().add(colBtn);

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
	@FXML
	public void openBai33(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai33.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void openBai32b(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai32b.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void openBai32b(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai32b.fxml"));
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

	public void openBai1(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
