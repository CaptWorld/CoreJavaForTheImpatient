package ch01.ex12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class Ex12Test {
    @Test @Timeout(10)
    void fieldScenarios() {
        assertFields(1.0, false, 1023, 0L);
        assertFields(-2.5, true, 1024, 0x4000000000000L);
        assertFields(Double.MIN_VALUE, false, 0, 1L);
        assertFields(Double.MAX_VALUE, false, 2046, 0xFFFFFFFFFFFFFL);
        assertFields(0.1, false, 1019, 0x999999999999AL);
    }

    @Test @Timeout(10)
    void fieldRoundTrips() {
        Random random = new Random(112);
        for (int i = 0; i < 5000;) {
            long bits = random.nextLong();
            double x = Double.longBitsToDouble(bits);
            if (Double.isNaN(x)) continue;
            double rebuilt = Ex12.rebuild(Ex12.isNegative(x), Ex12.biasedExponent(x), Ex12.fraction(x));
            assertEquals(bits, Double.doubleToRawLongBits(rebuilt));
            i++;
        }
    }

    @Test @Timeout(10)
    void classifications() {
        assertEquals("zero", Ex12.classify(0.0));
        assertEquals("zero", Ex12.classify(-0.0));
        assertEquals("nan", Ex12.classify(Double.NaN));
        assertEquals("infinity", Ex12.classify(-1.0 / 0));
        assertEquals("normal", Ex12.classify(1.0));
        assertEquals("subnormal", Ex12.classify(Double.MIN_VALUE));
    }

    @Test @Timeout(10)
    void nextValueScenarios() {
        for (double x : new double[] {0.0, Double.MIN_VALUE, Double.MAX_VALUE}) {
            assertEquals(Double.doubleToRawLongBits(Math.nextUp(x)), Double.doubleToRawLongBits(Ex12.nextUpByBits(x)));
        }
    }

    @Test @Timeout(10)
    void nextValueComparison() {
        Random random = new Random(212);
        for (int i = 0; i < 5000;) {
            double x = Double.longBitsToDouble(random.nextLong() & Long.MAX_VALUE);
            if (!Double.isFinite(x) || x == 0) continue;
            assertEquals(Double.doubleToRawLongBits(Math.nextUp(x)), Double.doubleToRawLongBits(Ex12.nextUpByBits(x)));
            i++;
        }
    }

    private static void assertFields(double x, boolean negative, int exponent, long fraction) {
        assertEquals(negative, Ex12.isNegative(x));
        assertEquals(exponent, Ex12.biasedExponent(x));
        assertEquals(fraction, Ex12.fraction(x));
    }
}
