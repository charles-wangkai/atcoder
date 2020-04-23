import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static long solve(String s) {
        return search(s, 0, 0);
    }

    static long search(String s, int index, long sum) {
        if (index == s.length()) {
            return sum;
        }

        long result = 0;
        for (int i = index; i < s.length(); ++i) {
            result += search(s, i + 1, sum + Long.parseLong(s.substring(index, i + 1)));
        }

        return result;
    }
}