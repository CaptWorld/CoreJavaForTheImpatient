package ch01.ex08;

import java.math.BigInteger;

public class Ex08 {
    public static int largestFactorialArgument(long limit) {
        long value = 1;
        int n = 1;
        while (value <= limit / (n + 1)) value *= ++n;
        return n;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static int collatzSteps(long start) {
        int steps = 0;
        while (start != 1) {
            start = (start & 1) == 0 ? start / 2 : 3 * start + 1;
            steps++;
        }
        return steps;
    }

    public static long collatzPeak(long start) {
        long peak = start;
        while (start != 1) {
            start = (start & 1) == 0 ? start / 2 : 3 * start + 1;
            peak = Math.max(peak, start);
        }
        return peak;
    }

    public static int longestCollatzBelow(int limit) {
        int best = 1, most = 0;
        for (int start = 2; start < limit; start++) {
            int steps = collatzSteps(start);
            if (steps > most) {
                best = start;
                most = steps;
            }
        }
        return best;
    }
}
