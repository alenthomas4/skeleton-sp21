package timingtest;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // Create ALists to store our results
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        // We're always doing 10000 getLast operations regardless of N
        int M = 10000;

        // Test different sizes of lists (powers of 2 starting from 1000)
        for (int N = 1000; N <= 128000; N *= 2) {
            // 1. Create an SLList
            SLList<Integer> list = new SLList<>();

            // 2. Add N items to the SLList
            for (int i = 0; i < N; i++) {
                list.addLast(i);
            }

            // 3. Start the timer
            Stopwatch sw = new Stopwatch();

            // 4. Perform M getLast operations on the SLList
            for (int i = 0; i < M; i++) {
                list.getLast();
            }

            // 5. Check the timer
            double timeInSeconds = sw.elapsedTime();

            // Store results for this N
            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(M);
        }

        // Print the results
        printTimingTable(Ns, times, opCounts);
    }

}
