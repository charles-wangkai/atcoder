import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String w = sc.next();

        System.out.println(solve(w) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String w) {
        int[] counts = new int[26];
        w.chars().forEach(ch -> ++counts[ch - 'a']);

        return Arrays.stream(counts).allMatch(count -> count % 2 == 0);
    }
}