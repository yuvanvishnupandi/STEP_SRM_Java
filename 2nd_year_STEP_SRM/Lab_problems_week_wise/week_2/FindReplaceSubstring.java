//Problem 1: Find and replace all occurrences of a substring without using replace()
import java.util.Scanner;
import java.util.ArrayList;

public class FindReplaceSubstring {

    public static ArrayList<Integer> findOccurrences(String text, String sub) {
        ArrayList<Integer> positions = new ArrayList<>();
        int fromIndex = 0;
        while (true) {
            int index = text.indexOf(sub, fromIndex);
            if (index == -1) break;
            positions.add(index);
            fromIndex = index + 1;
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int findLen = find.length();
        int textLen = text.length();

        while (i < textLen) {
            if (i <= textLen - findLen && text.substring(i, i + findLen).equals(find)) {
                result.append(replace);
                i += findLen;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareReplace(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main text:");
        String text = sc.nextLine();

        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();

        System.out.println("Enter the substring to replace with:");
        String replace = sc.nextLine();

        ArrayList<Integer> positions = findOccurrences(text, find);
        System.out.println("Positions of substring occurrences: " + positions);

        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual Replace Result: " + manualResult);

        String builtinResult = text.replace(find, replace);
        System.out.println("Built-in Replace Result: " + builtinResult);

        System.out.println("Do both results match? " + compareReplace(manualResult, builtinResult));

        sc.close();
    }
}
