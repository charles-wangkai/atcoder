import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char X = sc.next().charAt(0);
        char Y = sc.next().charAt(0);

        System.out.println(solve(X, Y));

        sc.close();
    }

    static String solve(char X, char Y) {
        if (X < Y) {
            return "<";
        } else if (X > Y) {
            return ">";
        } else {
            return "=";
        }
    }
}