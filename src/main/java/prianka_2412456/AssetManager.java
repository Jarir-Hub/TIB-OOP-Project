package prianka_2412456;

import oop.practice.tiboopproject.User;
import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssetManager extends User implements Serializable {

    private static final String ASSET_FILE = "asset.bin";
    private static final String ASSIGNMENT_FILE = "assignmentRecord.bin";
    private static final String DAMAGE_LOG_FILE = "damageLog.bin";
    private static final String RETURN_RECORD_FILE = "returnRecord.bin";

    public final String managerName;

    public AssetManager(int userID, String password, String userType, String managerName) {
        super(userID, password, userType);
        this.managerName = managerName;
    }

    // ---------- CREATE ----------

    public Asset addAsset(String name, String serialNumber, double purchaseCost,
                          LocalDate purchaseDate, String catagory, String location) {

        List<Asset> existingAssets = viewAllAsset();

        if (!Asset.validateSerialNumberUnique(serialNumber, existingAssets)) {
            return null;
        }

        String newAssetID = "AST-" + (existingAssets.size() + 1);
        Asset asset = new Asset(newAssetID, name, serialNumber, purchaseCost,
                purchaseDate, catagory, Asset.STATUS_AVAILABLE, location, null);

        if (!asset.validateMandatoryFieldsFilled()) {
            return null;
        }

        boolean saved = BinaryFileUtility.writeObjects(ASSET_FILE, asset);
        return saved ? asset : null;
    }

    // ---------- READ ----------

    public ArrayList<Asset> viewAllAsset() {
        return BinaryFileUtility.readObjects(ASSET_FILE);
    }

    // ---------- SEARCH ----------

    public ArrayList<Asset> searchAsset(String keyword) {
        ArrayList<Asset> allAssets = viewAllAsset();
        ArrayList<Asset> matches = new ArrayList<>();
        for (Asset asset : allAssets) {
            if (asset.matchesSearchKeyword(keyword)) {
                matches.add(asset);
            }
        }
        return matches;
    }

    // ---------- VIEW BY LOCATION ----------

    public ArrayList<Asset> viewAssetByLocation(String location) {
        ArrayList<Asset> allAssets = viewAllAsset();
        ArrayList<Asset> matches = new ArrayList<>();
        for (Asset asset : allAssets) {
            if (asset.getLocation() != null && asset.getLocation().equalsIgnoreCase(location)) {
                matches.add(asset);
            }
        }
        return matches;
    }

    // ---------- VIEW BY STATUS ----------

    public ArrayList<Asset> viewAssetByStatus(String status) {
        ArrayList<Asset> allAssets = viewAllAsset();
        ArrayList<Asset> matches = new ArrayList<>();
        for (Asset asset : allAssets) {
            if (asset.getStatus() != null && asset.getStatus().equalsIgnoreCase(status)) {
                matches.add(asset);
            }
        }
        return matches;
    }

    // ---------- ASSIGN ASSET ----------

    public AssignmentRecord assignAsset(String assetID, String employeeID, LocalDate assignDate,
                                        String handoverConditionNotes, LocalDate expectedReturnDate) {

        ArrayList<Asset> existingAssets = viewAllAsset();

        Asset targetAsset = null;
        for (Asset asset : existingAssets) {
            if (asset.getAssetID().equals(assetID)) {
                targetAsset = asset;
                break;
            }
        }

        if (targetAsset == null || !Asset.STATUS_AVAILABLE.equalsIgnoreCase(targetAsset.getStatus())) {
            return null; // asset doesn't exist or isn't available to assign
        }

        String newAssignmentID = "ASG-" + (existingAssets.size() + 1);
        AssignmentRecord record = new AssignmentRecord(newAssignmentID, assetID, employeeID,
                assignDate, handoverConditionNotes, expectedReturnDate);

        targetAsset.setStatus(Asset.STATUS_ASSIGNED);
        targetAsset.setAssignTo(employeeID);
        BinaryFileUtility.overwriteObjects(ASSET_FILE, existingAssets);

        boolean saved = BinaryFileUtility.writeObjects(ASSIGNMENT_FILE, record);
        return saved ? record : null;
    }

    // ---------- MARK ASSET DAMAGE ----------

    public DamageLog markAssetDamage(String assetID, String damageDescription, String repairPriority) {
        ArrayList<Asset> existingAssets = viewAllAsset();

        DamageLog damageLog = new DamageLog(null, assetID, damageDescription, repairPriority, LocalDate.now());

        if (!damageLog.validateAssetExist(assetID, existingAssets)) {
            return null;
        }
        if (!damageLog.DescriptionMinLength()) {
            return null;
        }

        for (Asset asset : existingAssets) {
            if (asset.getAssetID().equals(assetID)) {
                asset.setStatus(Asset.STATUS_UNDER_REPAIR);
                break;
            }
        }
        BinaryFileUtility.overwriteObjects(ASSET_FILE, existingAssets);

        String newDamageID = "DMG-" + System.currentTimeMillis();
        damageLog.setDamageID(newDamageID);

        boolean saved = BinaryFileUtility.writeObjects(DAMAGE_LOG_FILE, damageLog);
        return saved ? damageLog : null;
    }

    // ---------- RETURN ASSET ----------

    public ReturnRecord returnAsset(String assetID, String employeeID, String returnCondition, String additionalNote) {
        ArrayList<Asset> existingAssets = viewAllAsset();

        Asset targetAsset = null;
        for (Asset asset : existingAssets) {
            if (asset.getAssetID().equals(assetID)) {
                targetAsset = asset;
                break;
            }
        }

        if (!ReturnRecord.validateAssetStatusAssigned(targetAsset)) {
            return null; // asset doesn't exist or isn't currently assigned
        }

        ReturnRecord record = new ReturnRecord();
        record.setReturnID("RET-" + System.currentTimeMillis());
        record.setAssetID(assetID);
        record.setEmployedID(employeeID);
        record.setRetunCondition(returnCondition);
        record.setAdditionalNote(additionalNote);
        record.setReturnDate(LocalDate.now());

        if (!record.validateReturnConditionSelected()) {
            return null;
        }

        targetAsset.setStatus(Asset.STATUS_AVAILABLE);
        targetAsset.setAssignTo(null);
        BinaryFileUtility.overwriteObjects(ASSET_FILE, existingAssets);

        boolean saved = BinaryFileUtility.writeObjects(RETURN_RECORD_FILE, record);
        return saved ? record : null;
    }
}