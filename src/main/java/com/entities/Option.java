package com.entities;

import java.io.Serializable;

public class Option implements Serializable {

    public Option() {

    }

    public Option(String content,String grade) {
        this.Content = content;
        this.Grade = grade;
    }
    String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    String Grade;
}
