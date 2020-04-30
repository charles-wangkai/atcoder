import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char a = sc.next().charAt(0);
        char b = sc.next().charAt(0);

        System.out.println(solve(a, b));

        sc.close();
    }

    static char solve(char a, char b) {
        return (a == b) ? 'H' : 'D';
    }
}