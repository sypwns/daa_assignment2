package metrics;

/**
 * Simple performance counter used by algorithms to report key operations.
 */
public class PerformanceTracker {
    private long comparisons = 0;
    private long accesses = 0;
    private long allocations = 0;

    private long startTime = 0;
    private long endTime = 0;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedMillis() {
        return (endTime - startTime) / 1_000_000;
    }

    public void incComparisons() { comparisons++; }
    public void incAccesses() { accesses++; }
    public void incAllocations() { allocations++; }

    public long getComparisons() { return comparisons; }
    public long getAccesses() { return accesses; }
    public long getAllocations() { return allocations; }

    public void reset() {
        comparisons = 0;
        accesses = 0;
        allocations = 0;
        startTime = 0;
        endTime = 0;
    }

    @Override
    public String toString() {
        return String.format("time(ms)=%d, comparisons=%d, accesses=%d, allocations=%d",
                getElapsedMillis(), comparisons, accesses, allocations);
    }

    public String toCSV() {
        return String.format("%d,%d,%d,%d", getElapsedMillis(), comparisons, accesses, allocations);
    }
}
