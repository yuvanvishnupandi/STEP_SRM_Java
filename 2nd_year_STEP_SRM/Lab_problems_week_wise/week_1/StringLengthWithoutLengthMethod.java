//Find Length of String Without Using length()

import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int lengthWithout = findLength(input);
        int lengthWith = input.length();

        System.out.println("Length without length(): " + lengthWithout);
        System.out.println("Length with length(): " + lengthWith);

        sc.close();
    }
}
