package ch01.ex04;

/**
 * <pre>
 * Ex04: Unicode text tools (about 30 minutes)
 *
 * All lengths below count Unicode code points (a character outside the
 * basic plane, such as an emoji, counts as one).
 *
 * public static String[] describeNonAscii(String line)
 *    One entry per non-ASCII character, in order, formatted "U+%04X &lt;char&gt;".
 *    "naïve café 😀 ok" -&gt; { "U+00EF ï", "U+00E9 é", "U+1F600 😀" }
 *
 * public static String truncate(String s, int max)    // max &gt;= 1
 *    If s has at most max code points it is returned unchanged. Otherwise the
 *    result is the first max-1 code points followed by the single character "…" (U+2026),
 *    so the result has exactly max code points.
 *
 * public static String centered(String s, int width)
 *    Pads s with spaces to the width. The left padding is (width - length) / 2
 *    rounded down and the rest goes on the right. If s is not shorter than width,
 *    it is returned unchanged.
 *
 * Tests: the scenarios below; randomized strings (fixed seed, built from a pool that
 * mixes ASCII, accented letters and emoji) checking that truncate returns a string with
 * no more than max code points, that it is a code-point prefix of the input plus "…",
 * that no unpaired surrogate appears in any result, and that centered
 * always has max(width, length) code points.
 *
 * Scenarios [verified], t = "héllo wörld 😀😀" (14 code points, 16 chars):
 * truncate(t, 14) -&gt; t; truncate(t, 13) -&gt; "héllo wörld …";
 * truncate(t, 12) -&gt; "héllo wörld…".
 * truncate("ab😀cd😀ef", 5) -&gt; "ab😀c…"; truncate("short", 10) -&gt; "short".
 * centered("hi", 7) -&gt; "  hi   "; centered("😀", 4) -&gt; " 😀  ";
 * centered("héllo", 4) -&gt; "héllo".
 * </pre>
 */
public class Ex04 {
    public static String[] describeNonAscii(String line) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String truncate(String s, int max) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String centered(String s, int width) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: Which of your methods would break if you had used `length()` and `charAt`, and how would it have broken?
A1:

Q2: What does "character" mean after this exercise? Name one case where a code point is still not what a reader sees as one character.
A2:
*/
