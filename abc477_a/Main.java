import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final char[] COLORS = {'B', 'Y', 'R'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char c = sc.next().charAt(0);

    System.out.println(solve(c));

    sc.close();
  }

  static char solve(char c) {
    int index = IntStream.range(0, COLORS.length).filter(i -> COLORS[i] == c).findAny().getAsInt();

    return COLORS[(index + 1) % COLORS.length];
  }
}