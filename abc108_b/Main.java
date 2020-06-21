import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.println(solve(x1, y1, x2, y2));

        sc.close();
    }

    static String solve(int x1, int y1, int x2, int y2) {
        Point[] points = new Point[4];
        points[0] = new Point(x1, y1);
        points[1] = new Point(x2, y2);

        for (int i = 2; i < points.length; ++i) {
            points[i] = rotate(points[i - 2], points[i - 1]);
        }

        return String.format("%d %d %d %d", points[2].x, points[2].y, points[3].x, points[3].y);
    }

    static Point rotate(Point p, Point o) {
        int dx = p.x - o.x;
        int dy = p.y - o.y;

        return new Point(o.x + dy, o.y - dx);
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