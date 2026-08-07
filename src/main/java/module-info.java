module oop.practice.tiboopproject {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires java.desktop;
=======
    requires javafx.graphics;
    requires oop.practice.tiboopproject;
    requires jdk.jdi;

>>>>>>> 6fca22a7ada5adb27c53862c24212371d8458a4d


    opens oop.practice.tiboopproject to javafx.fxml;
    exports oop.practice.tiboopproject;
    exports Jarir_Bin_Rakib_2431984;
    opens Jarir_Bin_Rakib_2431984 to javafx.fxml;

    exports mohona_2431026;
    opens mohona_2431026 to javafx.fxml;

    exports user;
    opens user to javafx.fxml;
<<<<<<< HEAD
    exports mohona_2431026;
    opens mohona_2431026 to javafx.fxml;
=======

>>>>>>> 6fca22a7ada5adb27c53862c24212371d8458a4d
}