package prianka_2412456;

import java.io.Serializable;
import java.time.LocalDate;

public class ReturnRecord implements Serializable {
    String returnID;
    String assetID;
    String employedID;
    String retunCondition;
    String additionalNote;
    LocalDate returnDate;


    public ReturnRecord(String returnID, String assetID, String employedID, String retunCondition, String additionalNote, LocalDate returnDate) {
        this.returnID = returnID;
        this.assetID = assetID;
        this.employedID = employedID;
        this.retunCondition = retunCondition;
        this.additionalNote = additionalNote;
        this.returnDate = returnDate;
    }

    public ReturnRecord() {

    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployedID() {
        return employedID;
    }

    public void setEmployedID(String employedID) {
        this.employedID = employedID;
    }

    public String getRetunCondition() {
        return retunCondition;
    }

    public void setRetunCondition(String retunCondition) {
        this.retunCondition = retunCondition;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    //
    public boolean validateReturnConditionSelected() {

        return retunCondition != null && !retunCondition.isBlank();


    }

    public static boolean validateAssetStatusAssigned(Asset asset) {
        return asset != null && Asset.STATUS_ASSIGNED.equalsIgnoreCase(asset.getStatus());

    }

}
