package mujahid_2411869;

import java.time.LocalDate;

public class Policy {
    private final long policyId;
    private String policyName; // {unique}
    private String category;
    private String policyText;
    private LocalDate effectiveDate;

    public Policy(String policyName, String category, String policyText, LocalDate effectiveDate) {
        this.policyId = System.currentTimeMillis();
        this.policyName = policyName;
        this.category = category;
        this.policyText = policyText;
        this.effectiveDate = effectiveDate;
    }

    public long getPolicyId() {
        return policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPolicyText() {
        return policyText;
    }

    public void setPolicyText(String policyText) {
        this.policyText = policyText;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", category='" + category + '\'' +
                ", policyText='" + policyText + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }


}