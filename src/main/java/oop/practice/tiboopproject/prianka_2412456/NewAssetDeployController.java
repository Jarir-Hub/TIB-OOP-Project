package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import oop.practice.tiboopproject.User;
import prianka_2412456.AssignmentRecord;
import prianka_2412456.AssetManager;
import prianka_2412456.Asset;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.time.LocalDate;

public class NewAssetDeployController implements UserReceiver {
    @FXML
    private TextField IDforDeployTF;
    @FXML
    private TextField handoverTF;

    private Asset assetToDeploy;   // set from the previous screen before this loads
    private User loggedInUser;

    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    /**
     * Called by the previous screen right after loading this FXML,
     * to tell this screen WHICH asset is being deployed/assigned.
     */
    public void setAssetToDeploy(Asset asset) {
        this.assetToDeploy = asset;
    }

    @FXML
    public void confirmDeployOA(ActionEvent actionEvent) {
        if (assetToDeploy == null) {
            return;
        }

        String employeeID = IDforDeployTF.getText();
        String handoverNotes = handoverTF.getText();

        AssignmentRecord record = assetManager.assignAsset(
                assetToDeploy.getAssetID(),
                employeeID,
                LocalDate.now(),
                handoverNotes,
                null
        );

        if (record == null) {
            return;
        }

        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/assetManager.fxml", loggedInUser);
    }
}