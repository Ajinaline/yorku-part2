module com.yorku {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.yorku to javafx.fxml;
    exports com.yorku;
}
