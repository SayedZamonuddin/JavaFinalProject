module org.uca.finalprojectexpensetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uca.finalprojectexpensetracker to javafx.fxml;
    exports org.uca.finalprojectexpensetracker;
}