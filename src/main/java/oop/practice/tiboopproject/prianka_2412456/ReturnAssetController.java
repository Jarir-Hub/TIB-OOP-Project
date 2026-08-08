package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import oop.practice.tiboopproject.User;
import prianka_2412456.Asset;
import prianka_2412456.AssetManager;
import prianka_2412456.ReturnRecord;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

public class ReturnAssetController implements UserReceiver {

    @FXML
    private Label Output_pervConditionStatus;

    @FXML
    private ComboBox<String> returnConditionCB;

    @FXML
    private Label output_success;

    private Asset assetToReturn;   // set via setAssetToReturn, before this screen is shown
    private User loggedInUser;     // set via setLoggedInUser, before this screen is shown

    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    /**
     * Called by the previous screen right after loading this FXML,
     * to tell this screen WHICH asset is being returned.
     */
    public void setAssetToReturn(Asset asset) {
        this.assetToReturn = asset;
        if (asset != null) {
            Output_pervConditionStatus.setText("Current status: " + asset.getStatus());
        }
    }

    @FXML
    public void initialize() {
        returnConditionCB.getItems().addAll("Good", "Damaged", "Lost");
    }

    @FXML
    public void confirmReturnOA(ActionEvent actionEvent) {
        if (assetToReturn == null) {
            output_success.setText("No asset selected for return.");
            return;
        }

        if (!ReturnRecord.validateAssetStatusAssigned(assetToReturn)) {
            output_success.setText("This asset is not currently assigned, so it can't be returned.");
            return;
        }

        String returnCondition = returnConditionCB.getValue();

        ReturnRecord tempRecord = new ReturnRecord();
        tempRecord.setRetunCondition(returnCondition);
        if (!tempRecord.validateReturnConditionSelected()) {
            output_success.setText("Please select a return condition.");
            return;
        }

        ReturnRecord savedRecord = assetManager.returnAsset(
                assetToReturn.getAssetID(),
                assetToReturn.getAssignTo(),
                returnCondition,
                null
        );

        if (savedRecord == null) {
            output_success.setText("Something went wrong while returning the asset.");
            return;
        }

        output_success.setText("Asset returned successfully.");

        // Navigate back to the dashboard, carrying the logged-in user along
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/assetManager.fxml", loggedInUser);
    }
}