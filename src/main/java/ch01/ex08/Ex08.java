package ch01.ex08;

import java.math.BigInteger;

/**
 * <pre>
 * Ex08: Number explorer (about 35 minutes)
 *
 * public static int largestFactorialArgument(long limit)     // limit &gt;= 1
 *    The largest n such that n! &lt;= limit. Self-policed: no BigInteger, and the answer
 *    must be right for limit = Long.MAX_VALUE (the exact answer is the point).
 *
 * public static BigInteger factorial(int n)                  // n &gt;= 0
 *
 * public static int collatzSteps(long start)                 // start &gt;= 1
 *    Collatz: while the value is not 1, halve it if even, else replace it by 3*value+1.
 *    Returns the number of such steps.
 * public static long collatzPeak(long start)
 *    The largest value reached (start itself counts).
 * public static int longestCollatzBelow(int limit)           // limit &gt;= 2
 *    The start value below limit with the most steps (the smallest one when tied).
 *
 * Tests: factorial scenarios (0, 20, 1000: 2568 digits, digit sum 10539, 249 trailing zeros);
 * largestFactorialArgument for 1, 5, 23, 24, Integer.MAX_VALUE, Long.MAX_VALUE, and 200 random limits
 * (fixed seed) against a BigInteger loop inside the test; collatzSteps and collatzPeak
 * scenarios plus random starts (fixed seed, below 5 million) against a reference in the
 * test; longestCollatzBelow(1_000_000) within the timeout.
 *
 * Values [verified]:
 * largestFactorialArgument: 1 -&gt; 1, 5 -&gt; 2, 23 -&gt; 3, 24 -&gt; 4,
 * Integer.MAX_VALUE -&gt; 12, Long.MAX_VALUE -&gt; 20.
 * 1000! has 2568 digits, digit sum 10539, 249 trailing zeros.
 * collatzSteps(27) = 111; collatzPeak(27) = 9232; collatzSteps(1) = 0;
 * collatzPeak(113383) = 2482111348.
 * longestCollatzBelow: 10 -&gt; 9, 100 -&gt; 97, 1000 -&gt; 871,
 * 1_000_000 -&gt; 837799 (524 steps).
 * </pre>
 */
public class Ex08 {
    public static int largestFactorialArgument(long limit) {
        throw new UnsupportedOperationException("TODO");
    }

    public static BigInteger factorial(int n) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int collatzSteps(long start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static long collatzPeak(long start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int longestCollatzBelow(int limit) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you detect that the next factorial no longer fits, without BigInteger?
A1:

Q2: What type did each Collatz variable need to be, and how did you find out?
A2:
*/
