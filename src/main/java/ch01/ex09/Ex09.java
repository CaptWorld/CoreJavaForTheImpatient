package ch01.ex09;

/**
 * <pre>
 * Ex09: IPv4 subnet helper (stretch, about 75 minutes)
 *
 * An IPv4 address is held in an int (its 32 bits). Prefix lengths 0 to 32 are all valid.
 *
 * public static int parse(String dotted)        // "192.168.1.77" -&gt; the 32 bits
 * public static String format(int address)      // the inverse; "255.255.255.255" for all ones
 * public static String info(String cidr)        // e.g. "192.168.1.77/26"
 *    Returns this text (text block, ends with a newline); "Addresses" is the
 *    total size of the block (2^(32-prefix)):
 *      Network:   192.168.1.64/26
 *      Mask:      255.255.255.192
 *      Broadcast: 192.168.1.127
 *      Addresses: 64
 * public static boolean contains(String cidr, String address)
 * public static String smallestCommonBlock(String first, String... rest)
 *    The CIDR block with the longest prefix that contains all the addresses,
 *    written as "&lt;network address&gt;/&lt;prefix&gt;". A single address gives its own /32.
 *
 * Tests: parse/format round trip over 1000 random ints (fixed seed); exact info output for
 * 192.168.1.77/26, 10.0.0.0/8, 8.8.8.8/32 and 1.2.3.4/0; contains compared with a reference
 * using long arithmetic inside the test (fixed seed); smallestCommonBlock scenarios below.
 *
 * Scenarios [verified]:
 * info("10.0.0.0/8"): network 10.0.0.0/8, mask 255.0.0.0,
 * broadcast 10.255.255.255, addresses 16777216.
 * info("8.8.8.8/32"): 8.8.8.8/32, 255.255.255.255, 8.8.8.8, 1.
 * info("1.2.3.4/0"): 0.0.0.0/0, 0.0.0.0, 255.255.255.255, 4294967296.
 * smallestCommonBlock("10.0.0.5") -&gt; "10.0.0.5/32"
 * smallestCommonBlock("192.168.1.10","192.168.1.200") -&gt; "192.168.1.0/24"
 * smallestCommonBlock("0.0.0.1","128.0.0.1") -&gt; "0.0.0.0/0"
 * smallestCommonBlock("172.16.5.1","172.16.9.200") -&gt; "172.16.0.0/20"
 * parse("128.0.0.0") -&gt; -2147483648; parse("192.168.1.77") -&gt; -1062731443.
 * </pre>
 */
public class Ex09 {
    public static int parse(String dotted) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String format(int address) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String info(String cidr) {
        throw new UnsupportedOperationException("TODO");
    }

    public static boolean contains(String cidr, String address) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String smallestCommonBlock(String first, String... rest) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: Which prefix lengths gave you trouble, and what did the failure look like?
A1:

Q2: How did you decide the shape of the `smallestCommonBlock` signature, and what does the compiler do for a call with one argument?
A2:
*/
