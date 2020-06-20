import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] grid = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                grid[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(grid));

        sc.close();
    }

    static String solve(char[][] grid) {
        List<Integer> rowIndices = new ArrayList<>();
        List<Integer> colIndices = new ArrayList<>();

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == '#') {
                    rowIndices.add(r);
                    colIndices.add(c);
                }
            }
        }

        rowIndices = rowIndices.stream().distinct().sorted().collect(Collectors.toList());
        colIndices = colIndices.stream().distinct().sorted().collect(Collectors.toList());

        char[][] result = new char[rowIndices.size()][colIndices.size()];
        for (int r = 0; r < rowIndices.size(); ++r) {
            for (int c = 0; c < colIndices.size(); ++c) {
                result[r][c] = grid[rowIndices.get(r)][colIndices.get(c)];
            }
        }

        return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
    }
}