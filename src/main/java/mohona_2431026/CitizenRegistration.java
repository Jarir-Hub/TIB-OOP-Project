package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

public class CitizenRegistration {

    @FXML
    private TextField nidTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usertextffield;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField addressTextArea;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    private final String FILE_NAME = "Citizen.bin";

    @FXML
    public void initialize() {

    }

    @FXML
    public void clearButton(ActionEvent actionEvent) {

        nameTextField.clear();
        nidTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();
        addressTextArea.clear();
        usertextffield.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }

    @FXML
    public void registerButton(ActionEvent actionEvent) {

        String name = nameTextField.getText();
        String nid = nidTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextArea.getText();
        String username = usertextffield.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Event-4 : Required field validation
        if (name.isEmpty() || nid.isEmpty() || phone.isEmpty()
                || email.isEmpty() || address.isEmpty()
                || username.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Registration Failed",
                    "Please fill up all required fields.");

            return;
        }

        // Password Match Check
        if (!password.equals(confirmPassword)) {

            showAlert(Alert.AlertType.ERROR,
                    "Registration Failed",
                    "Password and Confirm Password do not match.");

            return;
        }

        // Event-5 : Email already exists
        if (emailExists(email)) {

            showAlert(Alert.AlertType.ERROR,
                    "Registration Failed",
                    "This email is already registered.");

            return;
        }

        // Event-6
        Citizen citizen = new Citizen(
                username,
                password,
                name,
                nid,
                phone,
                email,
                address
        );

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {

                ObjectOutputStream oos =
                        new ObjectOutputStream(new FileOutputStream(file));

                oos.writeObject(citizen);
                oos.close();

            } else {

                AppendableObjectOutputStream aoos =
                        new AppendableObjectOutputStream(new FileOutputStream(file, true));

                aoos.writeObject(citizen);
                aoos.close();
            }

            // Event-7
            showAlert(Alert.AlertType.INFORMATION,
                    "Success",
                    "Citizen account registered successfully.");

            clearButton(null);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean emailExists(String email) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return false;
        }

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(file));

            while (true) {

                Citizen c = (Citizen) ois.readObject();

                if (c.getEmail().equalsIgnoreCase(email)) {
                    ois.close();
                    return true;
                }
            }

        } catch (EOFException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {

        System.out.println("Back Button Clicked");

    }

    private void showAlert(Alert.AlertType type,
                           String title,
                           String message) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}