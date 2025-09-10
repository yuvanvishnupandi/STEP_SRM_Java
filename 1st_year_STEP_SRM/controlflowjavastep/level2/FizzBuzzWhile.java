import java.util.Scanner;

class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        if (!input.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            input.close();
            return;
        }
        int number = input.nextInt();
        input.nextLine(); 

        if (number < 0) {
            System.out.println("Please enter a positive number.");
            input.close();
            return;
        }

        int i = 1;
        while (i <= number) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            i++;
        }
        input.close();
    }
}