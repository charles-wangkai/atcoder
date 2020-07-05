import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int result = 0;
        int count = 0;
        for (char ch : S.toCharArray()) {
            if ("ATCG".indexOf(ch) >= 0) {
                ++count;
                result = Math.max(result, count);
            } else {
                count = 0;
            }
        }

        return result;
    }
}