import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(N, queries));

    sc.close();
  }

  static String solve(int N, String[] queries) {
    List<Point> points = new ArrayList<>();
    for (int i = N; i >= 1; --i) {
      points.add(new Point(i, 0));
    }

    List<String> result = new ArrayList<>();
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("1")) {
        char C = fields[1].charAt(0);

        int x = points.getLast().x();
        int y = points.getLast().y();
        if (C == 'R') {
          ++x;
        } else if (C == 'L') {
          --x;
        } else if (C == 'U') {
          ++y;
        } else {
          --y;
        }

        points.add(new Point(x, y));
      } else {
        int p = Integer.parseInt(fields[1]);

        Point point = points.get(points.size() - p);
        result.add("%d %d".formatted(point.x(), point.y()));
      }
    }

    return String.join("\n", result);
  }
}

record Point(int x, int y) {}
