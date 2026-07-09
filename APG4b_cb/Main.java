import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int a0 = -1;
    int a1 = -1;
    int a2 = -1;
    int a3 = -1;
    int a4 = -1;
    int a5 = -1;

    a0 = f0(N);
    a1 = f1(N, M);
    a2 = f2(N);
    a3 = f3(N);
    // a4 = f4(N);
    a5 = f5(N, M);

    System.out.println("f0: " + a0);
    System.out.println("f1: " + a1);
    System.out.println("f2: " + a2);
    System.out.println("f3: " + a3);
    System.out.println("f4: " + a4);
    System.out.println("f5: " + a5);

    sc.close();
  }

  static int f0(int N) {
    return 1;
  }

  static int f1(int N, int M) {
    int s = 0;
    for (int i = 0; i < N; i++) {
      s++;
    }
    for (int i = 0; i < M; i++) {
      s++;
    }
    return s;
  }

  static int f2(int N) {
    int s = 0;
    for (int i = 0; i < N; i++) {
      int t = N;
      int cnt = 0;
      while (t > 0) {
        cnt++;
        t /= 2;
      }
      s += cnt;
    }
    return s;
  }

  static int f3(int N) {
    int s = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        s++;
      }
    }
    return s;
  }

  static int f4(int N) {
    int s = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        s += i + j;
      }
    }
    return s;
  }

  static int f5(int N, int M) {
    int s = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        s += i + j;
      }
    }
    return s;
  }
}