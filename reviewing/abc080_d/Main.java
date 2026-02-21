import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] s = new int[N];
        int[] t = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; ++i) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        System.out.println(solve(s, t, c, C));

        sc.close();
    }

    static int solve(int[] s, int[] t, int[] c, int C) {
        int[] sortedIndices = IntStream.range(0, s.length).boxed().sorted((i1, i2) -> Integer.compare(s[i1], s[i2]))
                .mapToInt(x -> x).toArray();

        List<Recorder> recorders = new ArrayList<>();
        for (int index : sortedIndices) {
            Recorder recorder = new Recorder(c[index], t[index]);

            int recorderIndex = findRecorder(s[index], c[index], recorders);
            if (recorderIndex == -1) {
                recorders.add(recorder);
            } else {
                recorders.set(recorderIndex, recorder);
            }
        }

        return recorders.size();
    }

    static int findRecorder(int startTime, int channel, List<Recorder> recorders) {
        int result = -1;
        for (int i = 0; i < recorders.size(); ++i) {
            if (recorders.get(i).channel == channel) {
                return i;
            }

            if (startTime > recorders.get(i).endTime) {
                result = i;
            }
        }

        return result;
    }
}

class Recorder {
    int channel;
    int endTime;

    Recorder(int channel, int endTime) {
        this.channel = channel;
        this.endTime = endTime;
    }
}