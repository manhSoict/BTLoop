package com.controllers;

import com.baitaplonoop.ExamApplication;
import com.entities.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class controllerBai74 implements Initializable {
    @FXML
    public Label LabelQuizname;
    @FXML
    public TextArea TextQ1,TextQ2,TextQ3,TextQ4,TextQ5;
    @FXML
    public Label Answer1a,Answer1b,Answer1c,Answer1d,Answer2a,Answer2b,Answer2c,Answer2d,Answer3a,Answer3b,Answer3c,Answer3d,Answer4a,Answer4b,Answer4c,Answer4d,Answer5a,Answer5b,Answer5c,Answer5d;

    List<Question> selectedQuestions = new ArrayList<>();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LabelQuizname.setText(ExamApplication.getNewQuiz());
        selectedQuestions = ExamApplication.getQuizQuestions();
        if(selectedQuestions.size() >= 5) {
            Question first = selectedQuestions.get(0);
            TextQ1.setText(first.getQuestion());
            Answer1a.setText(first.getOptions().get(0).getContent());
            Answer1b.setText(first.getOptions().get(1).getContent());
            Answer1c.setText(first.getOptions().get(2).getContent());
            Answer1d.setText(first.getOptions().get(3).getContent());
            Question second = selectedQuestions.get(1);
            TextQ2.setText(second.getQuestion());
            Answer2a.setText(second.getOptions().get(0).getContent());
            Answer2b.setText(second.getOptions().get(1).getContent());
            Answer2c.setText(second.getOptions().get(2).getContent());
            Answer2d.setText(second.getOptions().get(3).getContent());
            Question third = selectedQuestions.get(0);
            TextQ3.setText(third.getQuestion());
            Answer3a.setText(third.getOptions().get(0).getContent());
            Answer3b.setText(third.getOptions().get(1).getContent());
            Answer3c.setText(third.getOptions().get(2).getContent());
            Answer3d.setText(third.getOptions().get(3).getContent());
            Question fourth = selectedQuestions.get(0);
            TextQ4.setText(fourth.getQuestion());
            Answer4a.setText(fourth.getOptions().get(0).getContent());
            Answer4b.setText(fourth.getOptions().get(1).getContent());
            Answer4c.setText(fourth.getOptions().get(2).getContent());
            Answer4d.setText(fourth.getOptions().get(3).getContent());
            Question fifth = selectedQuestions.get(0);
            TextQ5.setText(fifth.getQuestion());
            Answer5a.setText(fifth.getOptions().get(0).getContent());
            Answer5b.setText(fifth.getOptions().get(1).getContent());
            Answer5c.setText(fifth.getOptions().get(2).getContent());
            Answer5d.setText(fifth.getOptions().get(3).getContent());
        }
    }

    public void Finish() {

    }
}
