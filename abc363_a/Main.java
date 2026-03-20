import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int[] MILESTONES = {1, 100, 200, 300};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();

    System.out.println(solve(R));

    sc.close();
  }

  static int solve(int R) {
    return Arrays.stream(MILESTONES).filter(milestone -> milestone > R).findFirst().getAsInt() - R;
  }
}