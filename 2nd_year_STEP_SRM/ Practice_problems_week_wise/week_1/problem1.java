public class problem1{
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String str3 = new String(charArray);

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("String 3: " + str3);

        System.out.println("Comparing using == : " + (str1 == str2));
        System.out.println("Comparing using .equals(): " + str1.equals(str2));

        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println(quote);
    }
}
