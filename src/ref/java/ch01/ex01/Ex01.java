package ch01.ex01;

public class Ex01 {
    public static String radixReport(int n) {
        return n + ": bin=" + Integer.toBinaryString(n) + " oct=" + Integer.toOctalString(n)
                + " hex=" + Integer.toHexString(n) + " recip=" + Double.toHexString(1.0 / n);
    }

    public static String[] unsignedArithmetic(String a, String b) {
        int x = Integer.parseUnsignedInt(a);
        int y = Integer.parseUnsignedInt(b);
        return new String[] {Integer.toUnsignedString(x + y), Integer.toUnsignedString(x - y),
                Integer.toUnsignedString(x * y), Integer.toUnsignedString(Integer.divideUnsigned(x, y)),
                Integer.toUnsignedString(Integer.remainderUnsigned(x, y))};
    }
}
