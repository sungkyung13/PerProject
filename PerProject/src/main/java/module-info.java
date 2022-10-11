module com.example.perproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.perproject to javafx.fxml;
    exports com.example.perproject;
    exports com.example.perproject.List;
    opens com.example.perproject.List to javafx.fxml;
    exports com.example.perproject.ToDo;
    opens com.example.perproject.ToDo to javafx.fxml;
    requires java.sql;
}
