package com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TestController extends BaseController
{
    @FXML
    private Button btn;

    @FXML
    public void onHelloButtonClick() {
        sceneManager.switchScene("Test.fxml");
    }
    @FXML
    public void changeToTestScene(MouseEvent event) throws IOException {
        sceneManager.switchScene("Test");
    }
}
