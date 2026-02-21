import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] S = new String[3];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next();
        }

        System.out.println(solve(S));

        sc.close();
    }

    static char solve(String[] S) {
        int indices[] = new int[S.length];
        int turn = 0;
        while (indices[turn] != S[turn].length()) {
            int nextTurn = S[turn].charAt(indices[turn]) - 'a';
            ++indices[turn];

            turn = nextTurn;
        }

        return (char) (turn + 'A');
    }
}