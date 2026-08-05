package prianka_2412456;

public class LocationSummary {

    String location;
    int totalAsset;
    int availableCount;
    int assignCount;
    int underRepairCount;
    int totalValue;

    public LocationSummary(String location, int totalAsset, int availableCount, int assignCount, int underRepairCount, int totalValue) {
        this.location = location;
        this.totalAsset = totalAsset;
        this.availableCount = availableCount;
        this.assignCount = assignCount;
        this.underRepairCount = underRepairCount;
        this.totalValue = totalValue;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalAsset() {
        return totalAsset;
    }

    public void setTotalAsset(int totalAsset) {
        this.totalAsset = totalAsset;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getAssignCount() {
        return assignCount;
    }

    public void setAssignCount(int assignCount) {
        this.assignCount = assignCount;
    }

    public int getUnderRepairCount() {
        return underRepairCount;
    }

    public void setUnderRepairCount(int underRepairCount) {
        this.underRepairCount = underRepairCount;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }


    //

    public void generateSummery(){

    }


    //
    public int calculateAvailableCount(){
        //
    }


    //
    public int calculateAssignCount(){

    }


    //
    public int underRepairCount(){

    }

    //
    public float CalculateTotalValue(){

    }
}
