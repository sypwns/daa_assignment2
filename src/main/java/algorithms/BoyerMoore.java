package algorithms;

import metrics.PerformanceTracker;
import java.util.Optional;

/**
 * Boyer-Moore majority vote algorithm implementation.
 * Returns Optional.empty() when there is no majority element (> n/2).
 */
public class BoyerMoore {

    /**
     * Finds a majority element (occurs > n/2) if it exists.
     *
     * @param arr     array of integers (may be empty)
     * @param tracker performance tracker (can be null)
     * @return Optional.of(majority) or Optional.empty()
     */
    public static Optional<Integer> findMajority(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new IllegalArgumentException("Input array must not be null");
        if (tracker == null) tracker = new PerformanceTracker();

        // Phase 1: find candidate
        Integer candidate = null;
        int count = 0;
        for (int value : arr) {
            tracker.incAccesses();
            if (count == 0) {
                candidate = value;
                count = 1;
                tracker.incAllocations();
            } else {
                tracker.incComparisons();
                if (value == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (candidate == null) return Optional.empty();

        // Phase 2: verify candidate
        long occurrences = 0;
        for (int value : arr) {
            tracker.incAccesses();
            if (value == candidate) occurrences++;
        }

        if (occurrences > arr.length / 2) {
            return Optional.of(candidate);
        } else {
            return Optional.empty();
        }
    }
}
