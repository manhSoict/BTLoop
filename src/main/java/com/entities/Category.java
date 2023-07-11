package com.entities;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    Category parent;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    List<Question> questions;
    int questionCount;
    List<Category> children;
    String name;
    String info;
    int idNumber;

    int treeLevel = 0;

    public Category() {
        children = new ArrayList<>();
        questions = new ArrayList<>();
        questionCount = 0;
    }

    public Category(String name) {
        children = new ArrayList<>();
        questions = new ArrayList<>();
        this.name = name;
        questionCount = 0;
    }

    public Category(String name, String info) {
        children = new ArrayList<>();
        questions = new ArrayList<>();
        this.name = name;
        this.info = info;
        questionCount = 0;
    }

    public Category(int id, String name, String info) {
        children = new ArrayList<>();
        questions = new ArrayList<>();
        this.name = name;
        this.info = info;
        this.idNumber = id;
        questionCount = 0;
    }

    public void addSubCategory(Category category) {
        getChildren().add(category);
        category.setParent(this);
        category.setTreeLevel(this.treeLevel+1);
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(int treeLevel) {
        this.treeLevel = treeLevel;
    }

    public void addQuestion(Question quest) {
        questions.add(quest);
        quest.setCategory(this);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public int getTotalQuestions() {
        if(children.size() == 0) {
            return questions.size();
        }
        int r = questions.size();
        for(Category category : children) {
            r += category.getTotalQuestions();
        }
        return r;
    }

    public String totalQuestionsString() {
        int total = getTotalQuestions();
        if (total == 0) return "";
        return " (" + total + ")";
    }
}
