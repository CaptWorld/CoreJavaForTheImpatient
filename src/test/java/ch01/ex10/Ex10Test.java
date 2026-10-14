package ch01.ex10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

class Ex10Test {
    private static final String INPUT = "Hello World\nhello again\nnothing here\nHELLO!\n";

    @Test @Timeout(10)
    void plainMatches() {
        assertEquals("hello again\n", output(new String[] {"hello"}, INPUT));
    }

    @Test @Timeout(10)
    void caseInsensitiveMatches() {
        assertEquals("Hello World\nhello again\nHELLO!\n", output(new String[] {"-i", "hello"}, INPUT));
        assertEquals(INPUT, output(new String[] {"-i", "o"}, INPUT));
    }

    @Test @Timeout(10)
    void numberedMatches() {
        assertEquals("1:Hello World\n2:hello again\n4:HELLO!\n", output(new String[] {"-n", "-i", "hello"}, INPUT));
    }

    @Test @Timeout(10)
    void countedMatches() {
        assertEquals("3\n", output(new String[] {"-c", "-i", "hello"}, INPUT));
        assertEquals("0\n", output(new String[] {"-c", "-n", "zzz"}, INPUT));
    }

    @Test @Timeout(10)
    void countComparison() {
        Random random = new Random(110);
        String[] words = {"hello", "HELLO", "Java", "world", "nothing", "here", "again"};
        for (int trial = 0; trial < 200; trial++) {
            StringBuilder input = new StringBuilder();
            int lines = 1 + random.nextInt(50);
            for (int i = 0; i < lines; i++) {
                input.append(words[random.nextInt(words.length)]).append(' ')
                        .append(words[random.nextInt(words.length)]).append('\n');
            }
            String pattern = words[random.nextInt(words.length)];
            boolean insensitive = random.nextBoolean();
            String[] plain = insensitive ? new String[] {"-i", pattern} : new String[] {pattern};
            String[] count = insensitive ? new String[] {"-i", "-c", pattern} : new String[] {"-c", pattern};
            String printed = output(plain, input.toString());
            assertEquals(printed.lines().count() + "\n", output(count, input.toString()));
        }
    }

    private static String output(String[] args, String input) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        Ex10.run(args, new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), new PrintStream(bytes, true, StandardCharsets.UTF_8));
        return bytes.toString(StandardCharsets.UTF_8);
    }
}
