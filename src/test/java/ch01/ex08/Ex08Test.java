package ch01.ex08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Random;

class Ex08Test {
    @Test @Timeout(10)
    void factorialScenarios() {
        assertEquals(BigInteger.ONE, Ex08.factorial(0));
        assertEquals(new BigInteger("2432902008176640000"), Ex08.factorial(20));
        String value = Ex08.factorial(1000).toString();
        assertEquals(2568, value.length());
        int digitSum = 0, zeros = 0;
        for (int i = 0; i < value.length(); i++) digitSum += value.charAt(i) - '0';
        for (int i = value.length() - 1; i >= 0 && value.charAt(i) == '0'; i--) zeros++;
        assertEquals(10539, digitSum);
        assertEquals(249, zeros);
    }

    @Test @Timeout(10)
    void factorialLimits() {
        long[] limits = {1, 5, 23, 24, Integer.MAX_VALUE, Long.MAX_VALUE};
        int[] expected = {1, 2, 3, 4, 12, 20};
        for (int i = 0; i < limits.length; i++) assertEquals(expected[i], Ex08.largestFactorialArgument(limits[i]));
    }

    @Test @Timeout(10)
    void factorialLimitComparison() {
        Random random = new Random(108);
        for (int i = 0; i < 200; i++) {
            long limit = random.nextLong(1, Long.MAX_VALUE);
            BigInteger bound = BigInteger.valueOf(limit), product = BigInteger.ONE;
            int n = 1;
            while (product.multiply(BigInteger.valueOf(n + 1)).compareTo(bound) <= 0) {
                product = product.multiply(BigInteger.valueOf(++n));
            }
            assertEquals(n, Ex08.largestFactorialArgument(limit));
        }
    }

    @Test @Timeout(10)
    void collatzScenarios() {
        assertEquals(111, Ex08.collatzSteps(27));
        assertEquals(9232L, Ex08.collatzPeak(27));
        assertEquals(0, Ex08.collatzSteps(1));
        assertEquals(2482111348L, Ex08.collatzPeak(113383));
    }

    @Test @Timeout(10)
    void collatzComparison() {
        Random random = new Random(208);
        for (int i = 0; i < 300; i++) {
            long start = 1 + random.nextInt(4999999);
            BigInteger value = BigInteger.valueOf(start), peak = value;
            int steps = 0;
            while (!value.equals(BigInteger.ONE)) {
                value = value.testBit(0) ? value.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE) : value.shiftRight(1);
                peak = peak.max(value);
                steps++;
            }
            assertEquals(steps, Ex08.collatzSteps(start));
            assertEquals(peak.longValueExact(), Ex08.collatzPeak(start));
        }
    }

    @Test @Timeout(10)
    void longestSequences() {
        assertEquals(9, Ex08.longestCollatzBelow(10));
        assertEquals(97, Ex08.longestCollatzBelow(100));
        assertEquals(871, Ex08.longestCollatzBelow(1000));
    }

    @Test @Timeout(30)
    void millionStarts() {
        assertEquals(837799, Ex08.longestCollatzBelow(1000000));
        assertEquals(524, Ex08.collatzSteps(837799));
    }
}
