import java.util.Scanner;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
    
        int num = sc.nextInt();
        sc.close();
        int[] digits = new int[10];
        int index = 0;
        
        while (num > 0) {
            digits[index++] = num % 10;
            num /= 10;
        }
        
        System.out.print("Reversed number: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
