package algorithms;

// test
import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;


public class BoyerMooreTest {


    @Test
    public void testEmpty() {
        PerformanceTracker t = new PerformanceTracker();
        Optional<Integer> r = BoyerMoore.findMajority(new int[0], t);
        assertFalse(r.isPresent());
    }


    @Test
    public void testSingle() {
        PerformanceTracker t = new PerformanceTracker();
        Optional<Integer> r = BoyerMoore.findMajority(new int[]{7}, t);
        assertTrue(r.isPresent());
        assertEquals(7, r.get());
    }


    @Test
    public void testMajorityExists() {
        int[] arr = {1,2,1,1,3,1,1};
        Optional<Integer> r = BoyerMoore.findMajority(arr, new PerformanceTracker());
        assertTrue(r.isPresent());
        assertEquals(1, r.get());
    }


    @Test
    public void testNoMajority() {
        int[] arr = {1,2,3,1,2,3};
        Optional<Integer> r = BoyerMoore.findMajority(arr, new PerformanceTracker());
        assertFalse(r.isPresent());
    }


    @Test
    public void testAllEqual() {
        int[] arr = {5,5,5,5,5};
        Optional<Integer> r = BoyerMoore.findMajority(arr, new PerformanceTracker());
        assertTrue(r.isPresent());
        assertEquals(5, r.get());
    }


    @Test
    public void testLargeWithDuplicates() {
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = (i % 3 == 0) ? 9 : i;
// 9 occurs roughly n/3 times -> no majority
        Optional<Integer> r = BoyerMoore.findMajority(arr, new PerformanceTracker());
        assertFalse(r.isPresent());
    }
}