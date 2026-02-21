import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n));

        sc.close();
    }

    static String solve(int n) {
        return String.valueOf(n).chars().mapToObj(ch -> String.valueOf((char) ('1' + '9' - ch)))
                .collect(Collectors.joining());
    }
}