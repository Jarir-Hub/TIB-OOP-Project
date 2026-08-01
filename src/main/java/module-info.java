module oop.practice.tiboopproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.practice.tiboopproject to javafx.fxml;
    exports oop.practice.tiboopproject;
    exports Jarir_Bin_Rakib;
    opens Jarir_Bin_Rakib to javafx.fxml;
    exports user;
    opens user to javafx.fxml;
}