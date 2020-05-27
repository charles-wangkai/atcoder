import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        System.out.println(solve(a, b, H));

        sc.close();
    }

    static int solve(int[] a, int[] b, int H) {
        PriorityQueue<Sword> pq = new PriorityQueue<>((s1, s2) -> -Integer.compare(s1.getDamage(), s2.getDamage()));
        for (int i = 0; i < a.length; ++i) {
            pq.offer(new Sword(new int[] { a[i], b[i] }, 1));
        }

        int result = 0;
        while (true) {
            Sword head = pq.poll();
            if (head.index == 0) {
                result += (H + head.getDamage() - 1) / head.getDamage();

                return result;
            }

            ++result;
            H -= head.getDamage();
            if (H <= 0) {
                return result;
            }

            --head.index;
            pq.offer(head);
        }
    }
}

class Sword {
    int[] damages;
    int index;

    Sword(int[] damages, int index) {
        this.damages = damages;
        this.index = index;
    }

    int getDamage() {
        return damages[index];
    }
}