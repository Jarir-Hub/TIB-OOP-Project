package prianka_2412456;

import java.time.LocalDate;

public class DamageLog {
    int damageID;
    int assetID;
    String damageDescription;
    String repairPriority;
    LocalDate reportedDate;

    public DamageLog(Integer damageID, Integer assetID, String damageDescription, String repairPriority, LocalDate reportedDate) {
        this.damageID = damageID;
        this.assetID = assetID;
        this.damageDescription = damageDescription;
        this.repairPriority = repairPriority;
        this.reportedDate = reportedDate;
    }

    public Integer getDamageID() {
        return damageID;
    }

    public void setDamageID(Integer damageID) {
        this.damageID = damageID;
    }

    public Integer getAssetID() {
        return assetID;
    }

    public void setAssetID(Integer assetID) {
        this.assetID = assetID;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public String getRepairPriority() {
        return repairPriority;
    }

    public void setRepairPriority(String repairPriority) {
        this.repairPriority = repairPriority;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }



    // validation

    public boolean DescriptionMinLength(){

        //
        return false;
    }


    public boolean validateAssetExist(){

        //
        return false;
    }
}
