import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char X = sc.next().charAt(0);

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(char X) {
    return X - 'A' + 1;
  }
}