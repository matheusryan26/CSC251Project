public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    public Policy(int num, String provider, PolicyHolder holder) {
        policyNumber = num;
        providerName = provider;
        policyHolder = new PolicyHolder(holder);
    }

    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public PolicyHolder getPolicyHolder() { return new PolicyHolder(policyHolder); }

    public double getPolicyPrice() {
        double baseFee = 600;
        double bmi = policyHolder.getBMI();

        if (bmi > 35)
            baseFee += 75;

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
            baseFee += 100;

        return baseFee;
    }
}
