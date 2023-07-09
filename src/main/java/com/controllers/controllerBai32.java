package com.controllers;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerBai32 implements Initializable {
        @FXML
        public ComboBox<String> GradeC1,GradeC2,GradeC3,GradeC4,GradeC5;
        @FXML
        public Label creatnewquestion;
        @FXML
        private CheckBox showQuestion;
        @FXML
        private ScrollPane morequestion;
        @FXML
        private TableView<Question> questionTable;


        ObservableList<String> list = FXCollections.observableArrayList("None","100%","90%","83.33333%","80%","75%","70%","66.66667%","60%","50%","40%","33.33333%","30%","25%","20%","16.66667%","14.28571%","12%","11.11111%","10%","5%","-5%");
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            GradeC1.setItems(list);
            GradeC2.setItems(list);
//            GradeC3.setItems(list);
//            GradeC4.setItems(list);
//            GradeC5.setItems(list);
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
