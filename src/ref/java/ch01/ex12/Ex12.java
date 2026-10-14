package ch01.ex12;

public class Ex12 {
    public static boolean isNegative(double x) {
        return Double.doubleToRawLongBits(x) < 0;
    }

    public static int biasedExponent(double x) {
        return (int) ((Double.doubleToRawLongBits(x) >>> 52) & 0x7FF);
    }

    public static long fraction(double x) {
        return Double.doubleToRawLongBits(x) & 0xFFFFFFFFFFFFFL;
    }

    public static double rebuild(boolean negative, int biasedExponent, long fraction) {
        return Double.longBitsToDouble((negative ? Long.MIN_VALUE : 0L)
                | ((long) biasedExponent << 52) | fraction);
    }

    public static String classify(double x) {
        int exponent = biasedExponent(x);
        long fraction = fraction(x);
        if (exponent == 2047) return fraction == 0 ? "infinity" : "nan";
        if (exponent == 0) return fraction == 0 ? "zero" : "subnormal";
        return "normal";
    }

    public static double nextUpByBits(double x) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(x) + 1);
    }
}
