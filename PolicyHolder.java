public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;


    public PolicyHolder(String fName, String lName, int a, String smoking, double h, double w) {
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = smoking;
        height = h;
        weight = w;
    }

    public PolicyHolder(PolicyHolder other) {
        firstName = other.firstName;
        lastName = other.lastName;
        age = other.age;
        smokingStatus = other.smokingStatus;
        height = other.height;
        weight = other.weight;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    public String toString() {
        return "Policyholder's First Name: " + firstName +
               "\nPolicyholder's Last Name: " + lastName +
               "\nPolicyholder's Age: " + age +
               "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
               String.format("\nPolicyholder's Height: %.1f inches", height) +
               String.format("\nPolicyholder's Weight: %.1f pounds", weight) +
               String.format("\nPolicyholder's BMI: %.2f", getBMI());
    }
}
