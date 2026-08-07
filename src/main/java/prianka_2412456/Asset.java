package prianka_2412456;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Asset implements Serializable {

    String assetID;
    String name;
    String serialNumber;
    int purchaseCost;
    LocalDate purchaseDate;
    String catagory;
    String status;
    String location;
    String assignTo;

// constutctor

    public Asset(int userID, String password, String userType, String assetManager) {

    }

    public Asset(int userID, String password, String userType, String assetManager, String assetID, String name, String serialNUM, int purchaseCost, LocalDate purchaseDate, String catagory, String status, String location, String assignTo) {

        this.assetID = assetID;
        this.name = name;
        this.serialNumber = serialNUM;
        this.purchaseCost = purchaseCost;
        this.purchaseDate = purchaseDate;
        this.catagory = catagory;
        this.status = status;
        this.location = location;
        this.assignTo = assignTo;
    }

    // getter and setter

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(int purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }


    // custom method starts here

    public boolean validateMandatoryFieldsFilled() {
        return name != null && !name.isBlank()
                && serialNumber != null && !serialNumber.isBlank()
                && catagory != null && !catagory.isBlank()
                && purchaseDate != null
                && purchaseCost >= 0;
    }

    public static boolean validateSerialNumberUnique(String serialNumber, List<Asset> existingAssets) {
        if (serialNumber == null || serialNumber.isBlank()) {
            return false;
        }
        for (Asset asset : existingAssets) {
            if (asset.getSerialNumber() != null && asset.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return false;
            }
        }
        return true;
    }

    public boolean updateStatus(String newStatus) {
        if (newStatus == null || newStatus.isBlank()) {
            return false;
        }
        this.status = newStatus;
        return true;
    }

    public boolean matchesSearchKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return true;
        }
        String lowerKeyword = keyword.toLowerCase();
        return (name != null && name.toLowerCase().contains(lowerKeyword))
                || (serialNumber != null && serialNumber.toLowerCase().contains(lowerKeyword))
                || (location != null && location.toLowerCase().contains(lowerKeyword));
    }

    @Override
    public String toString() {
        return name + " (" + serialNumber + ")";
    }




}
