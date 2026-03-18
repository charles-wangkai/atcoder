import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int B = sc.nextInt();
    int G = sc.nextInt();

    System.out.println(solve(B, G));

    sc.close();
  }

  static String solve(int B, int G) {
    return (B > G) ? "Bat" : "Glove";
  }
}