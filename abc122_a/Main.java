import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char b = sc.next().charAt(0);

        System.out.println(solve(b));

        sc.close();
    }

    static char solve(char b) {
        if (b == 'A') {
            return 'T';
        } else if (b == 'T') {
            return 'A';
        } else if (b == 'C') {
            return 'G';
        } else {
            return 'C';
        }
    }
}