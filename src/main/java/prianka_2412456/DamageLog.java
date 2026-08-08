package prianka_2412456;

import java.time.LocalDate;
import java.util.List;

public class DamageLog {
    String damageID;
    String assetID;
    String damageDescription;
    String repairPriority;
    LocalDate reportedDate;

    public DamageLog(String damageID, String assetID, String damageDescription, String repairPriority, LocalDate reportedDate) {
        this.damageID = damageID;
        this.assetID = assetID;
        this.damageDescription = damageDescription;
        this.repairPriority = repairPriority;
        this.reportedDate = reportedDate;
    }

    public String getDamageID() {
        return damageID;
    }

    public void setDamageID(String damageID) {
        this.damageID = damageID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
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

        return damageDescription != null &&
                damageDescription.trim().length() >= 30;
    }

    public boolean validateAssetExist(String assetID, List<Asset> existingAssets){

        if( assetID == null || assetID.isBlank()){

            return false;

        }
        for (Asset asset : existingAssets){
            if (asset.getAssetID().equals(assetID)){
                return true;
            }

        }
        return false;

    }
}
