import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String s) {
        int count = 0;
        List<Character> rests = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            while (rests.size() >= 2 && ch != rests.get(rests.size() - 2)) {
                rests.remove(rests.size() - 1);
                ++count;
            }

            rests.add(ch);
        }

        return (count % 2 == 0) ? "Second" : "First";
    }
}