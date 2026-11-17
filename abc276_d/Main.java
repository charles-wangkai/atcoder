import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] a = new int[N];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }
  }

  static int solve(int[] a) {
    Element[] elements = Arrays.stream(a).mapToObj(Main::buildElement).toArray(Element[]::new);
    if (Arrays.stream(elements).mapToInt(Element::rest).distinct().count() != 1) {
      return -1;
    }

    int minExponent2 = Arrays.stream(elements).mapToInt(Element::exponent2).min().getAsInt();
    int minExponent3 = Arrays.stream(elements).mapToInt(Element::exponent3).min().getAsInt();

    return Arrays.stream(elements).mapToInt(element -> element.exponent2() - minExponent2).sum()
        + Arrays.stream(elements).mapToInt(element -> element.exponent3() - minExponent3).sum();
  }

  static Element buildElement(int x) {
    int rest = x;

    int exponent2 = 0;
    while (rest % 2 == 0) {
      ++exponent2;
      rest /= 2;
    }

    int exponent3 = 0;
    while (rest % 3 == 0) {
      ++exponent3;
      rest /= 3;
    }

    return new Element(rest, exponent2, exponent3);
  }
}

record Element(int rest, int exponent2, int exponent3) {}
