import java.util.Scanner;

public class Main {
  static final char[] NAMES = {'F', 'M', 'T'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(V, A, B, C));

    sc.close();
  }

  static char solve(int V, int A, int B, int C) {
    int[] volumes = {A, B, C};
    int index = 0;
    while (true) {
      if (V < volumes[index]) {
        return NAMES[index];
      }

      V -= volumes[index];
      index = (index + 1) % volumes.length;
    }
  }
}