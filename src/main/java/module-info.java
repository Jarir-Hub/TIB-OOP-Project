module oop.practice.tiboopproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.practice.tiboopproject to javafx.fxml;
    exports oop.practice.tiboopproject;
}