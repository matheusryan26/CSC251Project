import java.util.*;
import java.io.*;


public class Demo {
    public static void main(String[] args) throws IOException {

        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        ArrayList<Policy> policies = new ArrayList<>();

        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (inputFile.hasNext()) {
            String line = inputFile.nextLine().trim();
            if (line.isEmpty()) break;
    
            int policyNumber = Integer.parseInt(inputFile.nextLine());
            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = Integer.parseInt(inputFile.nextLine());
            String smokingStatus = inputFile.nextLine();
            double height = Double.parseDouble(inputFile.nextLine());
            double weight = Double.parseDouble(inputFile.nextLine());

            PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);


            policies.add(policy);

            if (smokingStatus.equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        inputFile.close();

        for (Policy p : policies) {
            System.out.println(p);
            System.out.println();
        }

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
