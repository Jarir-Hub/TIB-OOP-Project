package prianka_2412456;

import java.time.LocalDate;

public class ReturnRecord {
    int returnID;
    int assetID;
    int employedID;
    String retunCondition;
    String additionalNote;
    LocalDate returnDate;

    public ReturnRecord(int returnID, int assetID, int employedID, String retunCondition, String additionalNote, LocalDate returnDate) {
        this.returnID = returnID;
        this.assetID = assetID;
        this.employedID = employedID;
        this.retunCondition = retunCondition;
        this.additionalNote = additionalNote;
        this.returnDate = returnDate;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
    }

    public int getAssetID() {
        return assetID;
    }

    public void setAssetID(int assetID) {
        this.assetID = assetID;
    }

    public int getEmployedID() {
        return employedID;
    }

    public void setEmployedID(int employedID) {
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
    public boolean validateReturnConditionSelected(){

    }


    public boolean validateAssetStatusAssigned(){

    }

}
