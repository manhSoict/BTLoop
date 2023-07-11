package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.baitaplonoop.ExamApplication;
import com.entities.Category;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class controllerBai33 implements Initializable{
    @FXML
    public Label creatnewquestion,LabelQuestions,LabelImport,LabelIT;
    @FXML
    private ComboBox<Category> categoriesCombobox;
    @FXML
    private TextField categoryName;
    @FXML
    private TextArea categoryInfo;
    @FXML
    private TextField categoryId;

    ObservableList<Category> categories = FXCollections.observableArrayList();

    //for Create new Cate
    Category parent;
    void getAllCategories(Category root) {
        categories.add(root);
        for (Category category: root.getChildren()) {
            getAllCategories(category);
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
    public void openBai21(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai21.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllCategories(ExamApplication.getDefaultCategory());
        categoriesCombobox.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category category) {
                return category.getName();
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
                                    setText(itemString + item.getName());
                                } else {
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                });
        categoriesCombobox.setItems(categories);
        parent = categories.get(0);
        categoriesCombobox.setValue(parent);
    }

    @FXML
    public void onChangeParentCate(ActionEvent event) {
        parent = categoriesCombobox.getValue();
    }

    @FXML
    public void onSubmit(MouseEvent event) throws IOException {
        String name = categoryName.getText();
        String info = categoryInfo.getText();
        if (parent.getName() == name || name == "") {
            //BAo loi
            return;
        }
        for(Category category : parent.getChildren()) {
            if (category.getName() == name) {
                //Bao loi here
                return;
            }
        }
        if (!categoryId.getText().isEmpty()) {
            int id = Integer.parseInt(categoryId.getText());
            for(Category category : categories) {
                if (category.getIdNumber() == id) {
                    //Bao loi here (trung id)
                    System.out.println("Trung ID!");
                    return;
                }
            }
            parent.addSubCategory(new Category(id, name, info));
        } else {
            parent.addSubCategory(new Category(name, info));
        }
        ExamApplication.SaveData();
        openBai21(event);
    }
}
