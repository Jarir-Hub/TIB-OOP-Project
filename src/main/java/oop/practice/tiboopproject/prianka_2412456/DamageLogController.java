package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oop.practice.tiboopproject.User;
import prianka_2412456.AssetManager;
import prianka_2412456.DamageLog;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.time.LocalDate;

public class DamageLogController implements UserReceiver {

    @javafx.fxml.FXML
    private TextField damageIDTF;
    @javafx.fxml.FXML
    private TextField damageDescriptionOA;
    @javafx.fxml.FXML
    private DatePicker reportdate;
    @javafx.fxml.FXML
    private TextField assetIDdamageTF;
    @javafx.fxml.FXML
    private AnchorPane mainpaneDAMAGE;
    @javafx.fxml.FXML
    private ComboBox<String> repairCB;

    private User loggedInUser;   // received from the previous screen

    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void initialize() {
        repairCB.getItems().addAll("Low", "Medium", "High");
        // markAssetDamage() always stamps LocalDate.now() as the reported date,
        // so this picker is just a visual default - its value isn't sent anywhere.
        reportdate.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void confirmdamageOA(ActionEvent actionEvent) {
        String assetID = assetIDdamageTF.getText();
        String description = damageDescriptionOA.getText();
        String priority = repairCB.getValue();

        if (assetID == null || assetID.isBlank()) {
            damageIDTF.setText("Please enter the asset ID.");
            return;
        }
        if (priority == null) {
            damageIDTF.setText("Please choose a repair priority.");
            return;
        }

        DamageLog log = assetManager.markAssetDamage(assetID, description, priority);

        if (log == null) {
            damageIDTF.setText("Could not save. Check the asset ID exists and the description is long enough (30+ characters).");
            return;
        }

        damageIDTF.setText("Damage logged: " + log.getDamageID());
        assetIDdamageTF.clear();
        damageDescriptionOA.clear();
        repairCB.setValue(null);
    }

    @javafx.fxml.FXML
    public void backdamageOA(ActionEvent actionEvent) throws java.io.IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/assetManager.fxml", loggedInUser);
    }
}