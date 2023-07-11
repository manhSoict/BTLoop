package com.controllers;

import com.baitaplonoop.ExamApplication;
import com.entities.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerBai74 implements Initializable {
    @FXML
    public Label LabelQuizname;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LabelQuizname.setText(ExamApplication.getNewQuiz());
    }
}
