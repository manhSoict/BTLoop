package com.controllers ;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class controllerBai5 implements Initializable {
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
    private Spinner<Integer> monthSpinner;

    @FXML
    private Spinner<Integer> monthSpinner1;

    @FXML
    private Spinner<Integer> yearSpinner;

    @FXML
    private Spinner<Integer> yearSpinner1;

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        SpinnerValueFactory<Integer> dayValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1, 31, LocalDate.now().getDayOfMonth());
        daySpinner.setValueFactory(dayValueFactory);

        SpinnerValueFactory<Integer> monthValueFactory = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1, 12, LocalDate.now().getMonthValue());
        monthSpinner.setValueFactory(monthValueFactory);

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

        SpinnerValueFactory<Integer> monthValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1, 12, LocalDate.now().getMonthValue());
        monthSpinner1.setValueFactory(monthValueFactory1);

        SpinnerValueFactory<Integer> yearValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(1900, 2100, LocalDate.now().getYear());
        yearSpinner1.setValueFactory(yearValueFactory1);

        SpinnerValueFactory<Integer> hourValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        hourSpinner1.setValueFactory(hourValueFactory1);

        SpinnerValueFactory<Integer> minuteValueFactory1 = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        minuteSpinner1.setValueFactory(minuteValueFactory1);
    }


}

