import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S, K));

        sc.close();
    }

    static int solve(String S, int K) {
        int result = -1;
        Deque<Element> deque = new ArrayDeque<>();
        int totalLength = 0;
        int directionNum = 0;
        for (char value : S.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast().value == value) {
                ++deque.peekLast().length;
                ++totalLength;
            } else {
                if (value == '0') {
                    ++directionNum;
                }
                deque.offerLast(new Element(value, 1));
                ++totalLength;

                while (directionNum == K + 1) {
                    Element head = deque.pollFirst();
                    totalLength -= head.length;
                    if (head.value == '0') {
                        --directionNum;
                    }
                }
            }

            result = Math.max(result, totalLength);
        }

        return result;
    }
}

class Element {
    char value;
    int length;

    Element(char value, int length) {
        this.value = value;
        this.length = length;
    }
}