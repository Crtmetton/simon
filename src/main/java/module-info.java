module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;

    opens fr.esgi.controller to javafx.fxml;
    opens fr.esgi to javafx.fxml;

    exports fr.esgi.controller;
    exports fr.esgi;

}