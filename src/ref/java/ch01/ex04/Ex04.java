package ch01.ex04;

import java.util.ArrayList;
import java.util.Locale;

public class Ex04 {
    public static String[] describeNonAscii(String line) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < line.length();) {
            int cp = line.codePointAt(i);
            if (cp > 127) {
                result.add(String.format(Locale.ROOT, "U+%04X %s", cp, new String(Character.toChars(cp))));
            }
            i += Character.charCount(cp);
        }
        return result.toArray(new String[0]);
    }

    public static String truncate(String s, int max) {
        if (s.codePointCount(0, s.length()) <= max) return s;
        return s.substring(0, s.offsetByCodePoints(0, max - 1)) + "…";
    }

    public static String centered(String s, int width) {
        int padding = width - s.codePointCount(0, s.length());
        if (padding <= 0) return s;
        return " ".repeat(padding / 2) + s + " ".repeat(padding - padding / 2);
    }
}
