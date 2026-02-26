import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextInt();

    System.out.println("! %s".formatted((N == 26) ? solveForN26(sc) : solveForN5(sc)));
    System.out.flush();

    sc.close();
  }

  // https://stackoverflow.com/questions/1534748/design-an-efficient-algorithm-to-sort-5-distinct-keys-in-fewer-than-8-comparison
  static String solveForN5(Scanner sc) {
    char a = 'A';
    char b = 'B';
    char c = 'C';
    char d = 'D';
    char e = 'E';

    if (query(sc, a, b) == '>') {
      char temp = a;
      a = b;
      b = temp;
    }

    if (query(sc, c, d) == '>') {
      char temp = c;
      c = d;
      d = temp;
    }

    if (query(sc, a, c) == '>') {
      {
        char temp = a;
        a = c;
        c = temp;
      }
      {
        char temp = b;
        b = d;
        d = temp;
      }
    }

    char[] result;
    if (query(sc, e, c) == '>') {
      if (query(sc, e, d) == '>') {
        if (query(sc, b, d) == '>') {
          if (query(sc, b, e) == '>') {
            result = new char[] {a, c, d, e, b};
          } else {
            result = new char[] {a, c, d, b, e};
          }
        } else {
          if (query(sc, b, c) == '<') {
            result = new char[] {a, b, c, d, e};
          } else {
            result = new char[] {a, c, b, d, e};
          }
        }
      } else {
        if (query(sc, b, e) == '>') {
          if (query(sc, b, d) == '>') {
            result = new char[] {a, c, e, d, b};
          } else {
            result = new char[] {a, c, e, b, d};
          }
        } else {
          if (query(sc, b, c) == '<') {
            result = new char[] {a, b, c, e, d};
          } else {
            result = new char[] {a, c, b, e, d};
          }
        }
      }
    } else {
      if (query(sc, e, a) == '<') {
        if (query(sc, b, c) == '>') {
          if (query(sc, b, d) == '>') {
            result = new char[] {e, a, c, d, b};
          } else {
            result = new char[] {e, a, c, b, d};
          }
        } else {
          result = new char[] {e, a, b, c, d};
        }
      } else {
        if (query(sc, b, c) == '>') {
          if (query(sc, b, d) == '>') {
            result = new char[] {a, e, c, d, b};
          } else {
            result = new char[] {a, e, c, b, d};
          }
        } else {
          if (query(sc, b, e) == '<') {
            result = new char[] {a, b, e, c, d};
          } else {
            result = new char[] {a, e, b, c, d};
          }
        }
      }
    }

    return String.valueOf(result);
  }

  static String solveForN26(Scanner sc) {
    StringBuilder result = new StringBuilder();
    for (char ball = 'A'; ball <= 'Z'; ++ball) {
      result.insert(findIndex(sc, result, ball), ball);
    }

    return result.toString();
  }

  static int findIndex(Scanner sc, StringBuilder sequence, char ball) {
    int result = sequence.length();
    int lower = 0;
    int upper = sequence.length() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (query(sc, ball, sequence.charAt(middle)) == '<') {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static char query(Scanner sc, char c1, char c2) {
    System.out.println("? %c %c".formatted(c1, c2));
    System.out.flush();

    return sc.next().charAt(0);
  }
}