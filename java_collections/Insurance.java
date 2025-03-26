import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return "[Policy " + policyNumber + " | Holder: " + policyholderName + " | Expiry: " + expiryDate + " | Type: "
                + coverageType + " | Premium: " + premiumAmount + "]";
    }
}

class InsurancePolicyManagement {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    private Map<LocalDate, Policy> sortedPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        sortedPolicies.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        for (Map.Entry<LocalDate, Policy> entry : sortedPolicies.entrySet()) {
            if (!entry.getKey().isAfter(threshold)) {
                expiringSoon.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> holderPolicies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(holderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
    }

    public void displayPolicies() {
        for (Policy policy : insertionOrderMap.values()) {
            System.out.println(policy);
        }
    }
}

public class Insurance {
    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.0));
        manager.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800.0));
        manager.addPolicy(new Policy("P003", "Alice Brown", LocalDate.now().plusDays(10), "Home", 1500.0));

        System.out.println("🔹 All Policies:");
        manager.displayPolicies();

        System.out.println("\n🔹 Policies Expiring Soon:");
        System.out.println(manager.getPoliciesExpiringSoon());

        System.out.println("\n🔹 Policies for 'John Doe':");
        System.out.println(manager.getPoliciesByHolder("John Doe"));

        manager.removeExpiredPolicies();
        System.out.println("\n🔹 Policies After Removing Expired:");
        manager.displayPolicies();
    }
}