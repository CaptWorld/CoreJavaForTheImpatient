package ch01.ex09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

@Tag("stretch")
class Ex09Test {
    @Test @Timeout(10)
    void addressScenarios() {
        assertEquals(Integer.MIN_VALUE, Ex09.parse("128.0.0.0"));
        assertEquals(-1062731443, Ex09.parse("192.168.1.77"));
        assertEquals("255.255.255.255", Ex09.format(-1));
    }

    @Test @Timeout(10)
    void addressRoundTrips() {
        Random random = new Random(109);
        for (int i = 0; i < 1000; i++) {
            int address = random.nextInt();
            assertEquals(dotted(Integer.toUnsignedLong(address)), Ex09.format(address));
            assertEquals(address, Ex09.parse(Ex09.format(address)));
        }
    }

    @Test @Timeout(10)
    void subnetReports() {
        assertEquals("""
                Network:   192.168.1.64/26
                Mask:      255.255.255.192
                Broadcast: 192.168.1.127
                Addresses: 64
                """, Ex09.info("192.168.1.77/26"));
        assertEquals("""
                Network:   10.0.0.0/8
                Mask:      255.0.0.0
                Broadcast: 10.255.255.255
                Addresses: 16777216
                """, Ex09.info("10.0.0.0/8"));
        assertEquals("""
                Network:   8.8.8.8/32
                Mask:      255.255.255.255
                Broadcast: 8.8.8.8
                Addresses: 1
                """, Ex09.info("8.8.8.8/32"));
        assertEquals("""
                Network:   0.0.0.0/0
                Mask:      0.0.0.0
                Broadcast: 255.255.255.255
                Addresses: 4294967296
                """, Ex09.info("1.2.3.4/0"));
    }

    @Test @Timeout(10)
    void containsComparison() {
        Random random = new Random(209);
        for (int i = 0; i < 1000; i++) {
            long address = Integer.toUnsignedLong(random.nextInt());
            int prefix = i % 33;
            long size = 1L << (32 - prefix);
            long network = address / size * size;
            long candidate = (i & 1) == 0 ? network + random.nextLong(size) : Integer.toUnsignedLong(random.nextInt());
            boolean expected = candidate >= network && candidate < network + size;
            assertEquals(expected, Ex09.contains(dotted(address) + "/" + prefix, dotted(candidate)));
        }
    }

    @Test @Timeout(10)
    void commonBlocks() {
        assertEquals("10.0.0.5/32", Ex09.smallestCommonBlock("10.0.0.5"));
        assertEquals("192.168.1.0/24", Ex09.smallestCommonBlock("192.168.1.10", "192.168.1.200"));
        assertEquals("0.0.0.0/0", Ex09.smallestCommonBlock("0.0.0.1", "128.0.0.1"));
        assertEquals("172.16.0.0/20", Ex09.smallestCommonBlock("172.16.5.1", "172.16.9.200"));
    }

    private static String dotted(long address) {
        return (address / 16777216) + "." + (address / 65536 % 256) + "."
                + (address / 256 % 256) + "." + (address % 256);
    }
}
