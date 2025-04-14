public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    public Policy(int num, String provider, PolicyHolder holder) {
        policyNumber = num;
        providerName = provider;
        policyHolder = new PolicyHolder(holder);
        policyCount++;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }
    
    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder);
    }

    public double getPolicyPrice() {
        double baseFee = 600;
        double bmi = policyHolder.getBMI();

        if (bmi > 35) {
            baseFee += 75;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            baseFee += 100;
        }

        return baseFee;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName + "\n" +
               policyHolder.toString() +
               String.format("\nPolicy Price: $%.2f\n", getPolicyPrice());
    }
}
