import java.util.Random;

class StudentGrades {
    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = 50 + rand.nextInt(51);
            marks[i][1] = 50 + rand.nextInt(51);
            marks[i][2] = 50 + rand.nextInt(51);
        }
        return marks;
    }

    public static String[][] calculateScores(int[][] marks) {
        String[][] result = new String[marks.length][5];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = Math.round((avg * 100.0) / 100.0);
            result[i][0] = String.valueOf(marks[i][0]);
            result[i][1] = String.valueOf(marks[i][1]);
            result[i][2] = String.valueOf(marks[i][2]);
            result[i][3] = String.valueOf(total);
            result[i][4] = String.valueOf(percent);
        }
        return result;
    }

    public static String[] calculateGrade(String[][] scores) {
        String[] grades = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            double percent = Double.parseDouble(scores[i][4]);
            if (percent >= 90) grades[i] = "A";
            else if (percent >= 80) grades[i] = "B";
            else if (percent >= 70) grades[i] = "C";
            else if (percent >= 60) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] marks = generateMarks(5);
        String[][] scores = calculateScores(marks);
        String[] grades = calculateGrade(scores);

        System.out.println("Marks and Grades:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Marks: " + scores[i][0] + ", " + scores[i][1] + ", " + scores[i][2] +
                               " | Total: " + scores[i][3] + " | Percent: " + scores[i][4] +
                               " | Grade: " + grades[i]);
        }
    }
}