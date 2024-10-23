module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi;
}
