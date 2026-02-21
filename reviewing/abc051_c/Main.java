import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int tx = sc.nextInt();
        int ty = sc.nextInt();

        System.out.println(solve(sx, sy, tx, ty));

        sc.close();
    }

    static String solve(int sx, int sy, int tx, int ty) {
        int dx = tx - sx;
        int dy = ty - sy;

        return String.join("", repeat('U', dy), repeat('R', dx), repeat('D', dy), repeat('L', dx + 1),
                repeat('U', dy + 1), repeat('R', dx + 1), "DR", repeat('D', dy + 1), repeat('L', dx + 1), "U");
    }

    static String repeat(char ch, int count) {
        return IntStream.range(0, count).mapToObj(i -> String.valueOf(ch)).collect(Collectors.joining());
    }
}