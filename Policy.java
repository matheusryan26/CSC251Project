import java.text.DecimalFormat;

public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Constructor
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, 
                  String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Calculate BMI
    public double calculateBMI() {
        return (weight / (height * height)) * 703;
    }

    // Calculate Policy Price
    public double calculatePolicyPrice() {
        double basePrice = 500.00;
        
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            basePrice += 100.00;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            basePrice += (bmi - 35) * 2.00;
        }

        return basePrice;
    }

    // Display Policy Details
    public void displayPolicyInfo() {
        DecimalFormat df = new DecimalFormat("$#.00");

        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Provider Name: " + providerName);
        System.out.println("Policyholder's First Name: " + firstName);
        System.out.println("Policyholder's Last Name: " + lastName);
        System.out.println("Policyholder's Age: " + age);
        System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + smokingStatus);
        System.out.println("Policyholder's Height: " + height + " inches");
        System.out.println("Policyholder's Weight: " + weight + " pounds");
        System.out.printf("Policyholder's BMI: %.2f%n", calculateBMI());
        System.out.println("Policy Price: " + df.format(calculatePolicyPrice()));
        System.out.println();
    }

    // Getter for smoking status (used in Demo)
    public String getSmokingStatus() {
        return smokingStatus;
    }
}
