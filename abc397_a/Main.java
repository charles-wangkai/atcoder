import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double X = sc.nextDouble();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(double X) {
    int temperatureX10 = (int) Math.round(X * 10);
    if (temperatureX10 >= 380) {
      return 1;
    }
    if (temperatureX10 >= 375) {
      return 2;
    }

    return 3;
  }
}