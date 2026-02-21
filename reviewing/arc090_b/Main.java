import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] L = new int[M];
        int[] R = new int[M];
        int[] D = new int[M];
        for (int i = 0; i < M; ++i) {
            L[i] = sc.nextInt() - 1;
            R[i] = sc.nextInt() - 1;
            D[i] = sc.nextInt();
        }

        System.out.println(solve(N, L, R, D) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int N, int[] L, int[] R, int[] D) {
        Parent[] parents = new Parent[N];

        for (int i = 0; i < L.length; ++i) {
            Root rootL = findRoot(parents, L[i]);
            Root rootR = findRoot(parents, R[i]);

            if (rootL.index == rootR.index) {
                if (rootL.totalDelta + D[i] != rootR.totalDelta) {
                    return false;
                }
            } else {
                parents[rootR.index] = new Parent(rootL.index, rootL.totalDelta + D[i] - rootR.totalDelta);
            }
        }

        return true;
    }

    static Root findRoot(Parent[] parents, int node) {
        int rootIndex = node;
        int totalDelta = 0;
        while (parents[rootIndex] != null) {
            totalDelta += parents[rootIndex].delta;
            rootIndex = parents[rootIndex].index;
        }
        Root result = new Root(rootIndex, totalDelta);

        int p = node;
        while (p != rootIndex) {
            int nextIndex = parents[p].index;
            int nextTotalDelta = totalDelta - parents[p].delta;

            parents[p] = new Parent(rootIndex, totalDelta);

            p = nextIndex;
            totalDelta = nextTotalDelta;
        }

        return result;
    }
}

class Parent {
    int index;
    int delta;

    Parent(int index, int delta) {
        this.index = index;
        this.delta = delta;
    }
}

class Root {
    int index;
    int totalDelta;

    Root(int index, int totalDelta) {
        this.index = index;
        this.totalDelta = totalDelta;
    }
}