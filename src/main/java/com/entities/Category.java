package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    Category parent;
    List<Question> questions;
    int questionCount;
    List<Category> children;
    String name;
    String info;
    int idNumber;

    int treeLevel = 0;

    public Category() {
        children = new ArrayList<>();
        questionCount = 0;
    }

    public Category(String name) {
        children = new ArrayList<>();
        this.name = name;
        questionCount = 0;
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
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

}
