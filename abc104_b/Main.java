import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S) ? "AC" : "WA");

        sc.close();
    }

    static boolean solve(String S) {
        int[] uppercaseIndices = IntStream.range(0, S.length()).filter(i -> Character.isUpperCase(S.charAt(i)))
                .toArray();

        return S.charAt(0) == 'A' && uppercaseIndices.length == 2 && uppercaseIndices[1] >= 2
                && uppercaseIndices[1] <= S.length() - 2 && S.charAt(uppercaseIndices[1]) == 'C';
    }
}