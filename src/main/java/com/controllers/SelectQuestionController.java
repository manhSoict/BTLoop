package com.controllers;

import com.baitaplonoop.ExamApplication;
import com.entities.Category;
import com.entities.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectQuestionController implements Initializable {
    @FXML
    public ComboBox<Category> comboBox;
    @FXML
    private TableView<Question> questionTable;
    @FXML
    private TableColumn<Question, String> questionColumn;

    ObservableList<Category> categories = FXCollections.observableArrayList();
    ObservableList<Question> questions = FXCollections.observableArrayList();

    List<Question> selectedQuestions = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        questionColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getQuestion()));
        questionTable.setItems(questions);
        addCheckBoxToTable();
    }

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

    @FXML
    public void onChangeCategory(ActionEvent event) {
        questions.clear();
        getQuestions(comboBox.getValue());
        selectedQuestions.clear();
    }

    private void addCheckBoxToTable() {
        TableColumn<Question, Void> colBtn = new TableColumn("Select");

        Callback<TableColumn<Question, Void>, TableCell<Question, Void>> cellFactory = new Callback<TableColumn<Question, Void>, TableCell<Question, Void>>() {
            @Override
            public TableCell<Question, Void> call(final TableColumn<Question, Void> param) {
                final TableCell<Question, Void> cell = new TableCell<Question, Void>() {

                    private final CheckBox checkBox = new CheckBox();

                    {
                        checkBox.setOnAction((ActionEvent event) -> {
                            Question data = getTableView().getItems().get(getIndex());
                            if(checkBox.selectedProperty().get()) {
                                // add
                                selectedQuestions.add(data);
                            } else  {
                                //remove
                                selectedQuestions.remove(data);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(checkBox);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        questionTable.getColumns().add(0, colBtn);

    }


    @FXML
    public void onSubmit() {
        System.out.println("SElect " + selectedQuestions.size() +" questions!");
        ExamApplication.setQuizQuestions(selectedQuestions);
    }
}
