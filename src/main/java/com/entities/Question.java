package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

    public Question() {

    }
    int id;
    String question;

    List<Option> Options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
        Options = new ArrayList<>();
    }
}
