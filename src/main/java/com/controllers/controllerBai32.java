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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class controllerBai32 implements Initializable {
    public boolean more3choice,chooseLabelAdd,chooseLabelAddC1=false;
    @FXML
    private TextField questionName, questionMark;
    @FXML
    private TextArea questionText;
    @FXML
    private TextArea C1Text, C2Text, C3Text, C4Text, C5Text;
    @FXML
    public ComboBox<String> GradeC1,GradeC2,GradeC3,GradeC4,GradeC5;
    @FXML
    public Label morechoice,LabelSave,LabelCancel, LabelAddC1, LabelAdd,LabelAddC3,LabelAddC4,LabelAddC5;
    @FXML
    private CheckBox showQuestion;
    @FXML
    private ScrollPane morequestion;
    @FXML
    private AnchorPane Choice3,Choice4,Choice5,PaneLabel;
    @FXML
    private Pane PaneMain;
    @FXML
    private VBox VboxCauhoi,VboxC1;
//    @FXML
//    private TextArea TextCauhoi,TextC1;
    @FXML
    private ImageView ImageViewCauhoi,ImageViewC1;
    @FXML
    private ComboBox<Category> categoriesCombobox;

    Category category;
    ObservableList<Category> categories = FXCollections.observableArrayList();


        ObservableList<String> gradeList = FXCollections.observableArrayList("0","100","90","83.33333","80","75","70","66.66667","60","50","40","33.33333","30","25","20","16.66667","14.28571","12","11.11111","10","5","-5");
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
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
            category = categories.get(0);
            categoriesCombobox.setValue(category);
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
            Question quest = new Question();
            String name = questionName.getText();
            String questionTxt = questionText.getText();
            String markTxt = questionMark.getText();
            if(name == "" || questionTxt == "" || markTxt == "") {
                System.out.println("Tên, nội dung câu hỏi và điểm không được để trống");
                return;
            }
            quest.setQuestionName(name);
            quest.setQuestion(questionTxt);
            quest.setMark(Float.parseFloat(markTxt));
            List<Option> options = new ArrayList<>();
            options.add(new Option(C1Text.getText(), GradeC1.getValue()));
            options.add(new Option(C2Text.getText(), GradeC2.getValue()));
            if(more3choice) {
                options.add(new Option(C3Text.getText(), GradeC3.getValue()));
                options.add(new Option(C4Text.getText(), GradeC4.getValue()));
                options.add(new Option(C5Text.getText(), GradeC5.getValue()));
            }
            quest.setOptions(options);
            category.addQuestion(quest);
            ExamApplication.SaveData();
            openBai21(event);
        }
        @FXML
        public void clickBalnkmore3choice(MouseEvent event) throws IOException {
            if (more3choice==false) {
//                PaneMain.setPrefHeight(1128);
                Choice3.setVisible(true);
                Choice4.setVisible(true);
                Choice5.setVisible(true);
                PaneLabel.setLayoutX(285);
                PaneLabel.setLayoutY(1049);
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

    @FXML
    public void loadImageC1() {

        if (chooseLabelAddC1 == false){
            FileChooser fileChooserC1 = new FileChooser();
            fileChooserC1.setTitle("Choose Image");
            File file = fileChooserC1.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                ImageViewC1 = new ImageView(image);
                ImageViewC1.setFitHeight(37);
                ImageViewC1.setPreserveRatio(true);
                VboxC1.getChildren().add(ImageViewC1);
                LabelAddC1.setText("Delete image");
                chooseLabelAddC1 = true;
            }
        }
        else {
            VboxC1.getChildren().remove(ImageViewC1);
            C1Text.setPrefHeight(67);
            chooseLabelAddC1 = false;
            LabelAddC1.setText("Add image");
        }
    }
    @FXML
    public void loadImage() {

        if (chooseLabelAdd == false) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                ImageViewCauhoi = new ImageView(image);
                ImageViewCauhoi.setFitHeight(150);
                ImageViewCauhoi.setPreserveRatio(true);
                VboxCauhoi.getChildren().add(ImageViewCauhoi);
                LabelAdd.setText("Delete image");
                chooseLabelAdd = true;
            }
        } else {
            VboxCauhoi.getChildren().remove(ImageViewCauhoi);
            questionText.setPrefHeight(298);
            chooseLabelAdd = false;
            LabelAdd.setText("Add image");
        }
    }
}
