module oop.practice.tiboopproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;



    opens oop.practice.tiboopproject to javafx.fxml;
    exports oop.practice.tiboopproject;
    exports Jarir_Bin_Rakib_2431984;
    opens Jarir_Bin_Rakib_2431984 to javafx.fxml;

    exports mohona_2431026;
    opens mohona_2431026 to javafx.fxml;

    exports user;
    opens user to javafx.fxml;

}