package ch01.ex12;

/**
 * <pre>
 * Ex12: Float inspector (about 35 minutes)
 *
 * Take a double apart into its sign, exponent and fraction fields (the 64 bits: 1 sign bit,
 * 11 exponent bits, 52 fraction bits) and put it back together.
 *
 * public static boolean isNegative(double x)
 * public static int biasedExponent(double x)          // the raw 11-bit field, 0..2047
 * public static long fraction(double x)               // the raw 52-bit field
 * public static double rebuild(boolean negative, int biasedExponent, long fraction)   // the inverse
 * public static String classify(double x)             // "nan", "infinity", "zero", "subnormal" or "normal"
 * public static double nextUpByBits(double x)         // x is +0.0 or a positive finite value: the next larger double,
 *                                                   // +Infinity after Double.MAX_VALUE
 *
 * Self-policed: do not use Math.getExponent, Math.ulp, Math.nextUp or Math.scalb in your solution.
 *
 * Tests: field scenarios below; rebuild(isNegative(x), biasedExponent(x), fraction(x)) has the same raw
 * bits (Double.doubleToRawLongBits) as x for 5000 random bit patterns (fixed seed, NaN patterns excluded); classify scenarios;
 * nextUpByBits equals Math.nextUp for 5000 random positive finite x, for +0.0, Double.MIN_VALUE and Double.MAX_VALUE.
 *
 * Fields [verified]:
 * 1.0 -&gt; positive, exponent 1023, fraction 0.
 * -2.5 -&gt; negative, exponent 1024, fraction 0x4000000000000L.
 * Double.MIN_VALUE -&gt; positive, exponent 0, fraction 1 (classify "subnormal").
 * Double.MAX_VALUE -&gt; exponent 2046, fraction 0xFFFFFFFFFFFFFL.
 * 0.1 -&gt; exponent 1019, fraction 0x999999999999AL.
 * Classify: 0.0 and -0.0 -&gt; "zero"; Double.NaN -&gt; "nan";
 * -1.0/0 -&gt; "infinity"; 1.0 -&gt; "normal".
 * </pre>
 */
public class Ex12 {
    public static boolean isNegative(double x) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int biasedExponent(double x) {
        throw new UnsupportedOperationException("TODO");
    }

    public static long fraction(double x) {
        throw new UnsupportedOperationException("TODO");
    }

    public static double rebuild(boolean negative, int biasedExponent, long fraction) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String classify(double x) {
        throw new UnsupportedOperationException("TODO");
    }

    public static double nextUpByBits(double x) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: Which operators and which literal types did you need for the 52-bit field, and what failed first?
A1:

Q2: What does `nextUpByBits(Double.MAX_VALUE)` tell you about the layout of the bits?
A2:
*/
