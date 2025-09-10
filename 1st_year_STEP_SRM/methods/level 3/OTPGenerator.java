import java.util.HashSet;

public class OTPGenerator {

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        boolean allUnique = areOTPsUnique(otpArray);
        System.out.println("All OTPs are unique: " + (allUnique ? "Yes" : "No"));
    }

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;  // Range: 100000 to 999999
    }

    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) {
                return false;  // Duplicate found
            }
        }
        return true;  // All unique
    }
}
