import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(int S) {
    return (S >= 200 && S <= 299) ? "Success" : "Failure";
  }
}