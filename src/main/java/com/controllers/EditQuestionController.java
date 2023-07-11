package com.controllers;

import com.baitaplonoop.ExamApplication;
import com.entities.Category;
import com.entities.Option;
import com.entities.Question;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditQuestionController implements Initializable {
    public boolean more3choice;
    @FXML
    private TextField questionName, questionMark;
    @FXML
    private TextArea questionText;
    @FXML
    private TextArea C1Text, C2Text, C3Text, C4Text, C5Text;
    @FXML
    public ComboBox<String> GradeC1,GradeC2,GradeC3,GradeC4,GradeC5;
    @FXML
    public Label morechoice,LabelSave,LabelCancel,LabelAddC3,LabelAddC4,LabelAddC5;
    @FXML
    private CheckBox showQuestion;
    @FXML
    private ScrollPane morequestion;
    @FXML
    private AnchorPane Choice3,Choice4,Choice5,PaneLabel;
    @FXML
    private Pane PaneMain;
    @FXML
    private ComboBox<Category> categoriesCombobox;

    Category category;
    ObservableList<Category> categories = FXCollections.observableArrayList();
    Question editingQuestion;

    ObservableList<String> gradeList = FXCollections.observableArrayList("0","100","90","83.33333","80","75","70","66.66667","60","50","40","33.33333","30","25","20","16.66667","14.28571","12","11.11111","10","5","-5");
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        editingQuestion = ExamApplication.getEditingQuestion();

        more3choice = false;
        setupCombobox(GradeC1);
        setupCombobox(GradeC2);
        setupCombobox(GradeC3);
        setupCombobox(GradeC4);
        setupCombobox(GradeC5);
        Choice3.setVisible(false);
        Choice4.setVisible(false);
        Choice5.setVisible(false);
        PaneLabel.setLayoutX(285);
        PaneLabel.setLayoutY(740);
        LabelAddC3.setVisible(false);
        LabelAddC4.setVisible(false);
        LabelAddC5.setVisible(false);

        // setup categories
        getAllCategories(ExamApplication.getDefaultCategory());
        categoriesCombobox.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category category) {
                return category.getName() + category.totalQuestionsString();
            }

            @Override
            public Category fromString(String s) {
                return null;
            }
        });
        categoriesCombobox.setCellFactory(
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
        categoriesCombobox.setItems(categories);

        category = editingQuestion.getCategory();;
        categoriesCombobox.setValue(category);
        List<Option> options = editingQuestion.getOptions();
        if(options != null && options.size() >= 2) {
            C1Text.setText(options.get(0).getContent());
            GradeC1.setValue(options.get(0).getGrade());
            C2Text.setText(options.get(1).getContent());
            GradeC2.setValue(options.get(1).getGrade());
            if (options.size() >= 3) {
                toggleBalnkmore3choice();
                C3Text.setText(options.get(2).getContent());
                GradeC3.setValue(options.get(2).getGrade());
                C4Text.setText(options.get(3).getContent());
                GradeC4.setValue(options.get(3).getGrade());
                C5Text.setText(options.get(4).getContent());
                GradeC5.setValue(options.get(4).getGrade());
            }
        }
        questionName.setText(editingQuestion.getQuestionName());
        questionText.setText(editingQuestion.getQuestion());
        questionMark.setText(String.valueOf(editingQuestion.getMark()));
    }
    void getAllCategories(Category root) {
        categories.add(root);
        for (Category category: root.getChildren()) {
            getAllCategories(category);
        }
    }
    @FXML
    public void onChangeCategory(ActionEvent event) {
        category = categoriesCombobox.getValue();
    }

    public void onSubmit(MouseEvent event) throws IOException {
        String name = questionName.getText();
        String questionTxt = questionText.getText();
        String markTxt = questionMark.getText();
        if(name == "" || questionTxt == "" || markTxt == "") {
            System.out.println("Tên, nội dung câu hỏi và điểm không được để trống");
            return;
        }
        editingQuestion.setQuestionName(name);
        editingQuestion.setQuestion(questionTxt);
        editingQuestion.setMark(Float.parseFloat(markTxt));
        List<Option> options = new ArrayList<>();
        options.add(new Option(C1Text.getText(), GradeC1.getValue()));
        options.add(new Option(C2Text.getText(), GradeC2.getValue()));
        if(more3choice) {
            options.add(new Option(C3Text.getText(), GradeC3.getValue()));
            options.add(new Option(C4Text.getText(), GradeC4.getValue()));
            options.add(new Option(C5Text.getText(), GradeC5.getValue()));
        }

        editingQuestion.setOptions(options);

        if(category != editingQuestion.getCategory()) {
            editingQuestion.getCategory().removeQuestion(editingQuestion);
            category.addQuestion(editingQuestion);
        }
        ExamApplication.SaveData();
        openBai21(event);
    }
    @FXML
    public void toggleBalnkmore3choice(){
        if (more3choice==false) {
//                PaneMain.setPrefHeight(1128);
            Choice3.setVisible(true);
            Choice4.setVisible(true);
            Choice5.setVisible(true);
            PaneLabel.setLayoutX(285);
            PaneLabel.setLayoutY(1249);
            more3choice = true;
            morechoice.setText("DELETE 3 ADDED CHOICES");
            LabelAddC3.setVisible(true);
            LabelAddC4.setVisible(true);
            LabelAddC5.setVisible(true);
        }
        else{
//                PaneMain.setPrefHeight(850);
            Choice3.setVisible(false);
            Choice4.setVisible(false);
            Choice5.setVisible(false);

            PaneLabel.setLayoutX(285);
            PaneLabel.setLayoutY(740);
            more3choice = false;
            morechoice.setText("BLANK FOR MORE 3 CHOICES");
            LabelAddC3.setVisible(false);
            LabelAddC4.setVisible(false);
            LabelAddC5.setVisible(false);
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

    void setupCombobox(ComboBox<String> comboBox) {
        comboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String string) {
                if (string != "0")
                    return string + "%";
                else return "None";
            }

            @Override
            public String fromString(String s) {
                return null;
            }
        });
        comboBox.setCellFactory(
                new Callback<ListView<String>, ListCell<String>>() {
                    @Override public ListCell<String> call(ListView<String> param) {
                        final ListCell<String> cell = new ListCell<>() {
                            {
                                super.setPrefWidth(100);
                            }

                            @Override public void updateItem(String item,
                                                             boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    if (item == "0")
                                        setText("None");
                                    else
                                        setText(item + "%");
                                } else {
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                });
        comboBox.setItems(gradeList);
        comboBox.setValue(gradeList.get(0));
    }
}
