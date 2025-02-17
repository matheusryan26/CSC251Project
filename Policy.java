public class Policy {

    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeight;
    private double policyholderWeight;

    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_ADDITIONAL_FEE_RATE = 20.0;

    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.policyholderSmokingStatus = "non-smoker";
        this.policyholderHeight = 0.0;
        this.policyholderWeight = 0.0;
    }

    public Policy(int policyNumber, String providerName, String policyholderFirstName, String policyholderLastName,
                  int policyholderAge, String policyholderSmokingStatus, double policyholderHeight, double policyholderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderSmokingStatus = policyholderSmokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
    }


    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    public double calculateBMI() {
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    public double calculatePolicyPrice() {
        double totalFee = BASE_FEE;

        if (policyholderAge > 50) {
            totalFee += AGE_FEE;
        }

        if (policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            totalFee += SMOKER_FEE;
        }

        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalFee += (bmi - BMI_THRESHOLD) * BMI_ADDITIONAL_FEE_RATE;
        }

        return totalFee;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               "Policyholder's First Name: " + policyholderFirstName + "\n" +
               "Policyholder's Last Name: " + policyholderLastName + "\n" +
               "Policyholder's Age: " + policyholderAge + "\n" +
               "Policyholder's Smoking Status: " + policyholderSmokingStatus + "\n" +
               "Policyholder's Height: " + policyholderHeight + " inches\n" +
               "Policyholder's Weight: " + policyholderWeight + " pounds\n" +
               "Policyholder's BMI: " + String.format("%.2f", calculateBMI()) + "\n" +
               "Policy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }
}