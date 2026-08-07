module oop.practice.tiboopproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
<<<<<<< HEAD
    requires oop.practice.tiboopproject;
    requires jdk.jdi;
=======
    requires java.desktop;
<<<<<<< HEAD
>>>>>>> 7146a75f3157cad99e314a620e7d881eaac0b2a0
=======
    requires oop.practice.tiboopproject;
    requires java.sql;
>>>>>>> 460e1881f3f59188d40bd1caa9142ae1528c4b17

    // Main package (Contains HelloApplication, HelloController, User.java, etc.)
    exports oop.practice.tiboopproject;
    opens oop.practice.tiboopproject to javafx.fxml;

    // Sub-packages inside oop.practice.tiboopproject
    exports oop.practice.tiboopproject.mujahid_2411869;
    opens oop.practice.tiboopproject.mujahid_2411869 to javafx.fxml;

    exports oop.practice.tiboopproject.prianka_2412456;
    opens oop.practice.tiboopproject.prianka_2412456 to javafx.fxml;

    // Top-level packages under src/main/java
    exports Jarir_Bin_Rakib_2431984;
    opens Jarir_Bin_Rakib_2431984 to javafx.fxml;

    exports mohona_2431026;
    opens mohona_2431026 to javafx.fxml;

    exports mujahid_2411869;
    opens mujahid_2411869 to javafx.fxml;

    exports prianka_2412456;
    opens prianka_2412456 to javafx.fxml;
}