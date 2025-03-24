import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();

        policies.add(new Policy(3450, "State Farm", "Alice", "Jones", 20, "smoker", 65.0, 110.0));
        policies.add(new Policy(3455, "Aetna", "Bob", "Lee", 54, "non-smoker", 72.0, 200.0));
        policies.add(new Policy(2450, "Met Life", "Chester", "Williams", 40, "smoker", 71.0, 300.0));
        policies.add(new Policy(3670, "Global", "Cindy", "Smith", 55, "non-smoker", 62.0, 140.0));
        policies.add(new Policy(1490, "Reliable", "Jenna", "Lewis", 30, "smoker", 60.0, 105.0));
        policies.add(new Policy(3477, "State Farm", "Craig", "Duncan", 23, "smoker", 66.0, 215.0));

        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (Policy p : policies) {
            p.displayPolicyInfo();

            if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
