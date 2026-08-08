package prianka_2412456;

import java.util.List;

public class LocationSummary {

    String location;
    int totalAsset;
    int availableCount;
    int assignCount;
    int underRepairCount;
    double totalValue;

    public LocationSummary(String location, int totalAsset, int availableCount, int assignCount, int underRepairCount, double totalValue) {
        this.location = location;
        this.totalAsset = totalAsset;
        this.availableCount = availableCount;
        this.assignCount = assignCount;
        this.underRepairCount = underRepairCount;
        this.totalValue = totalValue;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getTotalAsset() { return totalAsset; }
    public void setTotalAsset(int totalAsset) { this.totalAsset = totalAsset; }

    public int getAvailableCount() { return availableCount; }
    public void setAvailableCount(int availableCount) { this.availableCount = availableCount; }

    public int getAssignCount() { return assignCount; }
    public void setAssignCount(int assignCount) { this.assignCount = assignCount; }

    public int getUnderRepairCount() { return underRepairCount; }
    public void setUnderRepairCount(int underRepairCount) { this.underRepairCount = underRepairCount; }

    public double getTotalValue() { return totalValue; }
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }

    public String generateSummary(List<Asset> assets) {
        int count = 0;
        for (Asset asset : assets) {
            if (location.equalsIgnoreCase(asset.getLocation())) {
                count++;
            }
        }
        this.totalAsset = count;

        this.availableCount = calculateAvailableCount(assets);
        this.assignCount = calculateAssignCount(assets);
        this.underRepairCount = calculateUnderRepairCount(assets);
        this.totalValue = calculateTotalValue(assets);

        return "Location: " + location + "\n" +
                "Total Assets: " + totalAsset + "\n" +
                "Available: " + availableCount + "\n" +
                "Assigned: " + assignCount + "\n" +
                "Under Repair: " + underRepairCount + "\n" +
                "Total Value: " + totalValue;
    }

    public int calculateAvailableCount(List<Asset> assets) {
        int count = 0;
        for (Asset asset : assets) {
            if (location.equalsIgnoreCase(asset.getLocation())
                    && Asset.STATUS_AVAILABLE.equalsIgnoreCase(asset.getStatus())) {
                count++;
            }
        }
        return count;
    }

    public int calculateAssignCount(List<Asset> assets) {
        int count = 0;
        for (Asset asset : assets) {
            if (location.equalsIgnoreCase(asset.getLocation())
                    && Asset.STATUS_ASSIGNED.equalsIgnoreCase(asset.getStatus())) {
                count++;
            }
        }
        return count;
    }

    public int calculateUnderRepairCount(List<Asset> assets) {
        int count = 0;
        for (Asset asset : assets) {
            if (location.equalsIgnoreCase(asset.getLocation())
                    && Asset.STATUS_UNDER_REPAIR.equalsIgnoreCase(asset.getStatus())) {
                count++;
            }
        }
        return count;
    }

    public double calculateTotalValue(List<Asset> assets) {
        double total = 0;
        for (Asset asset : assets) {
            if (location.equalsIgnoreCase(asset.getLocation())) {
                total += asset.getPurchaseCost();
            }
        }
        return total;
    }
}