package com.controllers ;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controllerBai5 implements Initializable {
    @FXML
    private Spinner<String>  wteSpinner;
    @FXML
    private Spinner<Integer> daySpinner;

    @FXML
    private Spinner<Integer> daySpinner1;

    @FXML
    private Spinner<Integer> hourSpinner;

    @FXML
    private Spinner<Integer> hourSpinner1;

    @FXML
    private Spinner<Integer> minuteSpinner;

    @FXML
    private Spinner<Integer> minuteSpinner1;

    @FXML
    private Spinner<String> monthSpinner;

    @FXML
    private Spinner<String> monthSpinner1;

    @FXML
    private Spinner<Integer> yearSpinner;

    @FXML
    private Spinner<Integer> yearSpinner1;
    @FXML
    private Label LabelCreat, LabelCancel;
    @FXML
    private CheckBox checkboxTimelimit;
    @FXML
    private TextField TextfieldTime;
    @FXML
    private Spinner SpinnerTime;

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        SpinnerValueFactory<Integer> dayValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1, 31, LocalDate.now().getDayOfMonth());
        daySpinner.setValueFactory(dayValueFactory);

        ObservableList<String> months = FXCollections.observableArrayList(
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                "November", "December");
        SpinnerValueFactory<String> monthValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);
        monthSpinner.setValueFactory(monthValueFactory);
        monthSpinner.getValueFactory().setValue(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM")));

        SpinnerValueFactory<Integer> yearValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1900, 2100, LocalDate.now().getYear());
        yearSpinner.setValueFactory(yearValueFactory);

        SpinnerValueFactory<Integer> hourValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        hourSpinner.setValueFactory(hourValueFactory);

        SpinnerValueFactory<Integer> minuteValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        minuteSpinner.setValueFactory(minuteValueFactory);

        SpinnerValueFactory<Integer> dayValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1, 31, LocalDate.now().getDayOfMonth());
        daySpinner1.setValueFactory(dayValueFactory1);

        SpinnerValueFactory<String> monthValueFactory1 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);
        monthSpinner1.setValueFactory(monthValueFactory1);
        monthSpinner1.getValueFactory().setValue(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM")));

        SpinnerValueFactory<Integer> yearValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1900, 2100, LocalDate.now().getYear());
        yearSpinner1.setValueFactory(yearValueFactory1);

        SpinnerValueFactory<Integer> hourValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        hourSpinner1.setValueFactory(hourValueFactory1);

        SpinnerValueFactory<Integer> minuteValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        minuteSpinner1.setValueFactory(minuteValueFactory1);



        SpinnerTime.setPromptText(" minutes");
        wteSpinner.setPromptText(" Open attempts are submitted automatically");

        //Cài đặt giá trị ban đầu cho timelimit
        TextfieldTime.setEditable(false);
        SpinnerTime.setEditable(false);
        TextfieldTime.setStyle("-fx-background-color: gray");
        SpinnerTime.setStyle("-fx-background-color: gray;");

    }

    public void openBai1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void clickcheckbox(MouseEvent event) throws IOException {
        if (checkboxTimelimit.isSelected()) {
            TextfieldTime.setEditable(true);
            SpinnerTime.setEditable(true);
            TextfieldTime.setStyle("-fx-background-color: white");
            SpinnerTime.setStyle("-fx-background-color: white;");

        } else {
            TextfieldTime.clear();
            TextfieldTime.setEditable(false);
            SpinnerTime.setEditable(false);
            TextfieldTime.setStyle("-fx-background-color: gray");
            SpinnerTime.setStyle("-fx-background-color: gray;");
        }
    }
}
