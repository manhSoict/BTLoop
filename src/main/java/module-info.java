module com.example.baitaplonoop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.baitaplonoop to javafx.fxml;
    exports com.baitaplonoop;
    exports com.controllers;
    opens com.controllers to javafx.fxml;
}