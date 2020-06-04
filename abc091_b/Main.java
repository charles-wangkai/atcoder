import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = readArray(sc);
        String[] t = readArray(sc);

        System.out.println(solve(s, t));

        sc.close();
    }

    static String[] readArray(Scanner sc) {
        int size = sc.nextInt();
        String[] result = new String[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.next();
        }

        return result;
    }

    static int solve(String[] s, String[] t) {
        Map<String, Integer> sValueToCount = buildValueToCount(s);
        Map<String, Integer> tValueToCount = buildValueToCount(t);

        return Math.max(0,
                sValueToCount.keySet().stream()
                        .mapToInt(sValue -> sValueToCount.get(sValue) - tValueToCount.getOrDefault(sValue, 0)).max()
                        .getAsInt());
    }

    static Map<String, Integer> buildValueToCount(String[] values) {
        Map<String, Integer> valueToCount = new HashMap<>();
        for (String value : values) {
            valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
        }

        return valueToCount;
    }
}