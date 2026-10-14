package ch01.ex09;

import java.util.Locale;

public class Ex09 {
    public static int parse(String dotted) {
        int result = 0;
        for (String octet : dotted.split("\\.")) result = (result << 8) | Integer.parseInt(octet);
        return result;
    }

    public static String format(int address) {
        return (address >>> 24) + "." + ((address >>> 16) & 255) + "."
                + ((address >>> 8) & 255) + "." + (address & 255);
    }

    private static int mask(int prefix) {
        return prefix == 0 ? 0 : -1 << (32 - prefix);
    }

    public static String info(String cidr) {
        String[] parts = cidr.split("/");
        int address = parse(parts[0]), prefix = Integer.parseInt(parts[1]);
        int mask = mask(prefix), network = address & mask;
        return String.format(Locale.ROOT, """
                Network:   %s/%d
                Mask:      %s
                Broadcast: %s
                Addresses: %d
                """, format(network), prefix, format(mask), format(network | ~mask), 1L << (32 - prefix));
    }

    public static boolean contains(String cidr, String address) {
        String[] parts = cidr.split("/");
        int mask = mask(Integer.parseInt(parts[1]));
        return (parse(parts[0]) & mask) == (parse(address) & mask);
    }

    public static String smallestCommonBlock(String first, String... rest) {
        int address = parse(first), different = 0;
        for (String next : rest) different |= address ^ parse(next);
        int prefix = Integer.numberOfLeadingZeros(different);
        return format(address & mask(prefix)) + "/" + prefix;
    }
}
