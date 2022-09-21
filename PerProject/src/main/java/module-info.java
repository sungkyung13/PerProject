module com.example.perproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.perproject to javafx.fxml;
    exports com.example.perproject;
}