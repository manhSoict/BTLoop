package com.tableEntities;

import com.entities.Question;
import javafx.beans.property.SimpleStringProperty;

public class QuestionRow extends Question {
    SimpleStringProperty question;

    public QuestionRow(String question) {
        this.question = new SimpleStringProperty(question);
    }
}
