package ch01.ex01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Random;

class Ex01Test {
    @Test @Timeout(10)
    void radixReports() {
        assertEquals("10: bin=1010 oct=12 hex=a recip=0x1.999999999999ap-4", Ex01.radixReport(10));
        assertEquals("-8: bin=11111111111111111111111111111000 oct=37777777770 hex=fffffff8 recip=-0x1.0p-3", Ex01.radixReport(-8));
        assertEquals("3: bin=11 oct=3 hex=3 recip=0x1.5555555555555p-2", Ex01.radixReport(3));
        assertEquals("255: bin=11111111 oct=377 hex=ff recip=0x1.010101010101p-8", Ex01.radixReport(255));
    }

    @Test @Timeout(10)
    void arithmeticScenarios() {
        assertArrayEquals(new String[] {"1", "4294967293", "4294967294", "2147483647", "1"}, Ex01.unsignedArithmetic("4294967295", "2"));
        assertArrayEquals(new String[] {"205032704", "1500000000", "1900150784", "2", "0"}, Ex01.unsignedArithmetic("3000000000", "1500000000"));
        assertArrayEquals(new String[] {"12", "4294967294", "35", "0", "5"}, Ex01.unsignedArithmetic("5", "7"));
        assertArrayEquals(new String[] {"13", "7", "30", "3", "1"}, Ex01.unsignedArithmetic("10", "3"));
    }

    @Test @Timeout(10)
    void arithmeticComparison() {
        Random random = new Random(101);
        BigInteger modulus = BigInteger.ONE.shiftLeft(32);
        int above = 0;
        for (int i = 0; i < 500; i++) {
            long x = Integer.toUnsignedLong(random.nextInt());
            long y;
            do { y = Integer.toUnsignedLong(random.nextInt()); } while (y == 0);
            if (x >= 2147483648L || y >= 2147483648L) above++;
            BigInteger a = BigInteger.valueOf(x), b = BigInteger.valueOf(y);
            String[] expected = {a.add(b).mod(modulus).toString(), a.subtract(b).mod(modulus).toString(),
                    a.multiply(b).mod(modulus).toString(), a.divide(b).toString(), a.remainder(b).toString()};
            assertArrayEquals(expected, Ex01.unsignedArithmetic(a.toString(), b.toString()));
        }
        assertTrue(above > 0);
    }
}
