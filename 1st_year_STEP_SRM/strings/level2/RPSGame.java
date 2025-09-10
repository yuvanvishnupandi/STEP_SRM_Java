import java.util.Scanner;

class RPSGame {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[(int)(Math.random() * 3)];
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))) return "User";
        return "Computer";
    }

    public static String[][] playGames(int rounds, Scanner sc) {
        String[][] results = new String[rounds][3];
        int userWins = 0, compWins = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.next();
            String comp = getComputerChoice();
            String winner = findWinner(user, comp);
            results[i][0] = user;
            results[i][1] = comp;
            results[i][2] = winner;
            if (winner.equals("User")) userWins++;
            if (winner.equals("Computer")) compWins++;
        }

        System.out.println("User Wins: " + userWins + ", Computer Wins: " + compWins);
        System.out.println("User Win %: " + (userWins * 100.0 / rounds) + ", Computer Win %: " + (compWins * 100.0 / rounds));
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rounds: ");
        int rounds = sc.nextInt();
        playGames(rounds, sc);
        sc.close();
    }
}