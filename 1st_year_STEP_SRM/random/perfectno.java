import java.util.Scanner;

public class perfectno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt(); 
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == num) {
            System.out.print(num + " is a perfect number"); 
        } else {
            System.out.print(num + " is not a perfect number"); 
        }
        sc.close();
    }
}