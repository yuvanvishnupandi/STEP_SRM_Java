//Problem 5: Extract and analyze different parts of email addresses
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class EmailAnalyzer {

    public static boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        if (atPos == -1 || atPos != lastAtPos) return false;
        if (atPos == 0 || atPos == email.length() - 1) return false;
        String domainPart = email.substring(atPos + 1);
        if (!domainPart.contains(".")) return false;
        if (domainPart.startsWith(".") || domainPart.endsWith(".")) return false;
        return true;
    }

    public static String getUsername(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    public static String getDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static String getDomainName(String domain) {
        int dotPos = domain.lastIndexOf('.');
        return domain.substring(0, dotPos);
    }

    public static String getExtension(String domain) {
        int dotPos = domain.lastIndexOf('.');
        return domain.substring(dotPos + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> emails = new ArrayList<>();

        System.out.println("Enter number of emails:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter email " + (i + 1) + ":");
            emails.add(sc.nextLine());
        }

        int validCount = 0, invalidCount = 0;
        int totalUsernameLength = 0;
        HashMap<String, Integer> domainFrequency = new HashMap<>();

        System.out.printf("%-30s %-20s %-20s %-20s %-10s %-10s%n",
                "Email", "Username", "Domain", "Domain Name", "Ext", "Valid");

        for (String email : emails) {
            boolean valid = isValidEmail(email);
            if (valid) {
                validCount++;
                String username = getUsername(email);
                String domain = getDomain(email);
                totalUsernameLength += username.length();
                String domainName = getDomainName(domain);
                String ext = getExtension(domain);

                domainFrequency.put(domain, domainFrequency.getOrDefault(domain, 0) + 1);

                System.out.printf("%-30s %-20s %-20s %-20s %-10s %-10s%n",
                        email, username, domain, domainName, ext, "Valid");
            } else {
                invalidCount++;
                System.out.printf("%-30s %-20s %-20s %-20s %-10s %-10s%n",
                        email, "-", "-", "-", "-", "Invalid");
            }
        }

        String mostCommonDomain = null;
        int maxFreq = 0;
        for (String d : domainFrequency.keySet()) {
            if (domainFrequency.get(d) > maxFreq) {
                maxFreq = domainFrequency.get(d);
                mostCommonDomain = d;
            }
        }

        double avgUsernameLen = validCount == 0 ? 0 : (double) totalUsernameLength / validCount;

        System.out.println("\nTotal valid emails: " + validCount);
        System.out.println("Total invalid emails: " + invalidCount);
        System.out.println("Most common domain: " + (mostCommonDomain == null ? "N/A" : mostCommonDomain));
        System.out.println("Average username length: " + avgUsernameLen);

        sc.close();
    }
}
