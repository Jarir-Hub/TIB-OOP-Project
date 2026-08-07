package prianka_2412456;

import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class AssignmentRecord  implements Serializable {
    private String assignmentID;
    private String assetID;
    private String employeeID;
    private LocalDate assignDate;
    private final String handoverConditionNotes;
    LocalDate expectedreturnDate;


    public AssignmentRecord(String assignmentID, String assetID, String employeeID, LocalDate assignDate, String handoverConditionNotes, LocalDate expectedreturnDate) {
        this.assignmentID = assignmentID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.assignDate = assignDate;
        this.handoverConditionNotes = handoverConditionNotes;
        this.expectedreturnDate = expectedreturnDate;
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }

    public String getHandoverConditionNotes() {
        return handoverConditionNotes;
    }

    public LocalDate getExpectedreturnDate() {
        return expectedreturnDate;
    }

    public void setExpectedreturnDate(LocalDate expectedreturnDate) {
        this.expectedreturnDate = expectedreturnDate;
    }



    public boolean validateEmployeeActive() {
        ArrayList<Object> accounts = BinaryFileUtility.readObjects("asset.bin");

        for (Object obj : accounts) {
            try {
                Asset asset = (Asset) obj;
                if (asset.getAssetID().equals(assetID) && "Active".equalsIgnoreCase(asset.getStatus())) {
                    return true;
                }
            } catch (ClassCastException e) {
                // obj wasn't an Account, skip it
            }
        }
        return false;
    }
}
