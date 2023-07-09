package com.entities;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    public Question() {

    }
    int id;
    String question;

    int CorrectAnsId;

    List<String> Answers;

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
    }

    public int getAns() {
        return CorrectAnsId;
    }

    public void setAns(int ans) {
        CorrectAnsId = ans;
    }
}
