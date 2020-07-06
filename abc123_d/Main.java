import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        int K = sc.nextInt();
        long[] A = readArray(sc, X);
        long[] B = readArray(sc, Y);
        long[] C = readArray(sc, Z);

        System.out.println(solve(A, B, C, K));

        sc.close();
    }

    static long[] readArray(Scanner sc, int size) {
        long[] result = new long[size];
        for (int i = 0; i < size; ++i) {
            result[i] = sc.nextLong();
        }

        return result;
    }

    static String solve(long[] A, long[] B, long[] C, int K) {
        long[] sortedA = reversedSort(A);
        long[] sortedB = reversedSort(B);
        long[] sortedC = reversedSort(C);

        List<Long> result = new ArrayList<>();
        Element initial = new Element(0, 0, 0);
        Set<Element> seen = new HashSet<>();
        seen.add(initial);
        PriorityQueue<Element> pq = new PriorityQueue<>(
                (e1, e2) -> -Long.compare(sortedA[e1.indexA] + sortedB[e1.indexB] + sortedC[e1.indexC],
                        sortedA[e2.indexA] + sortedB[e2.indexB] + sortedC[e2.indexC]));
        pq.offer(initial);

        while (result.size() != K) {
            Element head = pq.poll();
            result.add(sortedA[head.indexA] + sortedB[head.indexB] + sortedC[head.indexC]);

            for (Element candidate : new Element[] { new Element(head.indexA + 1, head.indexB, head.indexC),
                    new Element(head.indexA, head.indexB + 1, head.indexC),
                    new Element(head.indexA, head.indexB, head.indexC + 1) }) {
                if (candidate.indexA != A.length && candidate.indexB != B.length && candidate.indexC != C.length
                        && !seen.contains(candidate)) {
                    seen.add(candidate);
                    pq.offer(candidate);
                }
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }

    static long[] reversedSort(long[] values) {
        return Arrays.stream(values).boxed().sorted(Collections.reverseOrder()).mapToLong(x -> x).toArray();
    }
}

class Element {
    int indexA;
    int indexB;
    int indexC;

    Element(int indexA, int indexB, int indexC) {
        this.indexA = indexA;
        this.indexB = indexB;
        this.indexC = indexC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexA, indexB, indexC);
    }

    @Override
    public boolean equals(Object obj) {
        Element other = (Element) obj;

        return indexA == other.indexA && indexB == other.indexB && indexC == other.indexC;
    }
}