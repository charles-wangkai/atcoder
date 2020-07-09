import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String S) {
        boolean yymm = isMonth(S.substring(2));
        boolean mmyy = isMonth(S.substring(0, 2));

        if (yymm) {
            if (mmyy) {
                return "AMBIGUOUS";
            } else {
                return "YYMM";
            }
        } else {
            if (mmyy) {
                return "MMYY";
            } else {
                return "NA";
            }
        }
    }

    static boolean isMonth(String s) {
        int value = Integer.parseInt(s);

        return value >= 1 && value <= 12;
    }
}