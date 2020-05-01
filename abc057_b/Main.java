import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Point[] students = readPoints(sc, N);
        Point[] checkpoints = readPoints(sc, M);

        System.out.println(solve(students, checkpoints));

        sc.close();
    }

    static Point[] readPoints(Scanner sc, int size) {
        Point[] result = new Point[size];
        for (int i = 0; i < result.length; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            result[i] = new Point(x, y);
        }

        return result;
    }

    static String solve(Point[] students, Point[] checkpoints) {
        return Arrays.stream(students).map(student -> String.valueOf(find(checkpoints, student)))
                .collect(Collectors.joining("\n"));
    }

    static int find(Point[] checkpoints, Point student) {
        int minDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < checkpoints.length; ++i) {
            int distance = Math.abs(student.x - checkpoints[i].x) + Math.abs(student.y - checkpoints[i].y);
            if (distance < minDistance) {
                minDistance = distance;
                result = i + 1;
            }
        }

        return result;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}