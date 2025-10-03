package cli;

import algorithms.BoyerMoore;
import metrics.PerformanceTracker;

import java.util.Optional;
import java.util.Random;

/**
 * Command-line benchmark runner for Boyer-Moore Majority Vote.
 *
 * Usage:
 *   mvn -q exec:java -Dexec.mainClass="cli.BenchmarkRunner" -Dexec.args="1000 3 random"
 */
public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = 100;          // размер массива
        int runs = 3;          // сколько прогонов
        String distribution = "random"; // тип данных: random, sorted, reversed, nearly

        if (args.length >= 1) n = Integer.parseInt(args[0]);
        if (args.length >= 2) runs = Integer.parseInt(args[1]);
        if (args.length >= 3) distribution = args[2];

        System.out.println("daa_2 - Boyer-Moore Benchmark");
        System.out.printf("n=%d, runs=%d, distribution=%s%n", n, runs, distribution);
        System.out.println("run,elapsed_ms,comparisons,accesses,allocations,majorityFound,majorityValue");

        for (int r = 1; r <= runs; r++) {
            int[] arr = generateArray(n, distribution);
            PerformanceTracker tracker = new PerformanceTracker();

            tracker.startTimer();
            Optional<Integer> maj = BoyerMoore.findMajority(arr, tracker);
            tracker.stopTimer();

            System.out.printf("%d,%s,%b,%s%n",
                    r,
                    tracker.toCSV(),
                    maj.isPresent(),
                    maj.map(Object::toString).orElse(""));
        }
    }
// cli
    private static int[] generateArray(int n, String distribution) {
        Random rnd = new Random(42);
        int[] arr = new int[n];

        switch (distribution) {
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            case "nearly":
            case "nearly-sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                // перемешаем 1% элементов
                for (int i = 0; i < Math.max(1, n / 100); i++) {
                    int x = rnd.nextInt(n);
                    int y = rnd.nextInt(n);
                    int tmp = arr[x]; arr[x] = arr[y]; arr[y] = tmp;
                }
                break;
            case "random":
            default:
                for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(Math.max(1, n / 10));
        }
        return arr;
    }
}
