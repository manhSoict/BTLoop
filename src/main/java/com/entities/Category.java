package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    Category parent;
//    List<Question> question;
    List<Category> children;
    String name;
    String info;
    int idNumber;

    public void Category() {
        children = new ArrayList<>();
    }
}
