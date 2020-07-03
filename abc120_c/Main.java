import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int count0 = (int) S.chars().filter(ch -> ch == '0').count();
        int count1 = S.length() - count0;

        return Math.min(count0, count1) * 2;
    }
}