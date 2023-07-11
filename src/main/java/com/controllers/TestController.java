package com.controllers;

import com.entities.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {
    public boolean more3choice;

    @FXML
    public ComboBox<String> GradeC1,GradeC2,GradeC3,GradeC4,GradeC5;
    @FXML
    public Label morechoice,LabelSave,LabelCancel,LabelAdd;
    @FXML
    private CheckBox showQuestion;
    @FXML
    private ScrollPane morequestion;
    @FXML
    private AnchorPane Choice3,Choice4,Choice5,PaneLabel,AnchorCauhoi;
    @FXML
    private Pane PaneMain;
    @FXML
    private TableView<Question> questionTable;
    @FXML
    private VBox VboxCauhoi;
    @FXML
    private TextArea TextCauhoi;



    ObservableList<String> list = FXCollections.observableArrayList("None","100%","90%","83.33333%","80%","75%","70%","66.66667%","60%","50%","40%","33.33333%","30%","25%","20%","16.66667%","14.28571%","12%","11.11111%","10%","5%","-5%");
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        more3choice = false;
        GradeC1.setItems(list);
//        GradeC2.setItems(list);
//        GradeC3.setItems(list);
        GradeC4.setItems(list);
        GradeC5.setItems(list);
//        Choice3.setVisible(false);
        Choice4.setVisible(false);
        Choice5.setVisible(false);
        PaneLabel.setLayoutX(285);
        PaneLabel.setLayoutY(551);

    }
    @FXML
    public void clickBalnkmore3choice(MouseEvent event) throws IOException {
        if (more3choice==false) {
//                PaneMain.setPrefHeight(1128);
//            Choice3.setVisible(true);
            Choice4.setVisible(true);
            Choice5.setVisible(true);
            PaneLabel.setLayoutX(285);
            PaneLabel.setLayoutY(895);
            more3choice = true;
            morechoice.setText("DELETE 3 ADDED CHOICES");

        }
        else{
//                PaneMain.setPrefHeight(850);
//            Choice3.setVisible(false);
            Choice4.setVisible(false);
            Choice5.setVisible(false);

            PaneLabel.setLayoutX(285);
            PaneLabel.setLayoutY(551);
            more3choice = false;
            morechoice.setText("BLANK FOR MORE 3 CHOICES");

        }
    }

    @FXML
    public void openBai21(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai21.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);

            Label labelimage = new Label();
            labelimage.setPrefSize(imageView.getFitWidth(),imageView.getFitHeight());
            labelimage.setGraphic(imageView);
            VboxCauhoi.getChildren().add(labelimage);
        }
    }

}
