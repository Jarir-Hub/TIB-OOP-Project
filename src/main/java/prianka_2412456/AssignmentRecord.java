package prianka_2412456;

import java.time.LocalDate;

public class AssignmentRecord {
    int assignmentID;
    int assetID;
    int employeeID;
    LocalDate assignDate;
    LocalDate expectedreturnDate;

    public AssignmentRecord(Integer assignmentID, Integer assetID, Integer employeeID, LocalDate assignDate, LocalDate expectedreturnDate) {
        this.assignmentID = assignmentID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.assignDate = assignDate;
        this.expectedreturnDate = expectedreturnDate;
    }

    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    public Integer getAssetID() {
        return assetID;
    }

    public void setAssetID(Integer assetID) {
        this.assetID = assetID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }

    public LocalDate getExpectedreturnDate() {
        return expectedreturnDate;
    }

    public void setExpectedreturnDate(LocalDate expectedreturnDate) {
        this.expectedreturnDate = expectedreturnDate;
    }



    public boolean validateEmployeeActive(){

        return false;
    }
}
