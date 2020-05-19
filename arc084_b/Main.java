import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        System.out.println(solve(K));

        sc.close();
    }

    static int solve(int K) {
        int[] distances = new int[K];
        Arrays.fill(distances, -1);

        Deque<Element> deque = new ArrayDeque<>();
        deque.offerLast(new Element(1, 0));

        while (true) {
            Element head = deque.pollFirst();
            if (distances[head.index] != -1) {
                continue;
            }

            distances[head.index] = head.distance;
            if (head.index == 0) {
                return distances[head.index] + 1;
            }

            int nextInc = (head.index + 1) % K;
            if (distances[nextInc] == -1) {
                deque.offerLast(new Element(nextInc, head.distance + 1));
            }

            int nextMul = head.index * 10 % K;
            if (distances[nextMul] == -1) {
                deque.offerFirst(new Element(nextMul, head.distance));
            }
        }
    }
}

class Element {
    int index;
    int distance;

    Element(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}