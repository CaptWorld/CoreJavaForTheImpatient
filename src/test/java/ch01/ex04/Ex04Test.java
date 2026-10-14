package ch01.ex04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class Ex04Test {
    @Test @Timeout(10)
    void nonAsciiDescription() {
        assertArrayEquals(new String[] {"U+00EF ï", "U+00E9 é", "U+1F600 😀"},
                Ex04.describeNonAscii("naïve café 😀 ok"));
    }

    @Test @Timeout(10)
    void truncationScenarios() {
        String t = "héllo wörld 😀😀";
        assertEquals(t, Ex04.truncate(t, 14));
        assertEquals("héllo wörld …", Ex04.truncate(t, 13));
        assertEquals("héllo wörld…", Ex04.truncate(t, 12));
        assertEquals("ab😀c…", Ex04.truncate("ab😀cd😀ef", 5));
        assertEquals("short", Ex04.truncate("short", 10));
    }

    @Test @Timeout(10)
    void centeringScenarios() {
        assertEquals("  hi   ", Ex04.centered("hi", 7));
        assertEquals(" 😀  ", Ex04.centered("😀", 4));
        assertEquals("héllo", Ex04.centered("héllo", 4));
    }

    @Test @Timeout(10)
    void textProperties() {
        Random random = new Random(104);
        String[] pool = {"a", "Z", " ", "é", "ï", "ö", "😀", "🚀"};
        for (int i = 0; i < 500; i++) {
            StringBuilder input = new StringBuilder();
            int length = 1 + random.nextInt(40);
            for (int j = 0; j < length; j++) input.append(pool[random.nextInt(pool.length)]);
            String s = input.toString();
            int max = 1 + random.nextInt(45);
            String truncated = Ex04.truncate(s, max);
            int[] points = s.codePoints().toArray();
            String expected = length <= max ? s : new String(points, 0, max - 1) + "…";
            assertEquals(expected, truncated);
            assertTrue(truncated.codePointCount(0, truncated.length()) <= max);
            assertPairedSurrogates(truncated);
            int width = random.nextInt(45);
            String centered = Ex04.centered(s, width);
            assertEquals(Math.max(width, length), centered.codePointCount(0, centered.length()));
            assertPairedSurrogates(centered);
        }
    }

    private static void assertPairedSurrogates(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isHighSurrogate(c)) {
                assertTrue(i + 1 < text.length());
                assertTrue(Character.isLowSurrogate(text.charAt(++i)));
            } else assertFalse(Character.isLowSurrogate(c));
        }
    }
}
