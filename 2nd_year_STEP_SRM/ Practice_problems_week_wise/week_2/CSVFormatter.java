import java.util.Scanner;

public class CSVFormatter {
    public static String[] parseCSV(String input) {
        String[] fields = new String[10];
        int index = 0;
        StringBuilder field = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                fields[index++] = field.toString().trim();
                field.setLength(0);
            } else {
                field.append(input.charAt(i));
            }
        }
        fields[index] = field.toString().trim();
        return fields;
    }

    public static void displayFormattedData(String[] fields) {
        System.out.println("Formatted Data:");
        for (String field : fields) {
            if (field != null) {
                System.out.println(field);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data:");
        String input = sc.nextLine();
        String[] fields = parseCSV(input);
        displayFormattedData(fields);
        sc.close();
    }
}