package ch01.ex06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class Ex06Test {
    @Test @Timeout(10)
    void blockGeneration() {
        boolean[][] input = grid("....", ".##.", ".##.", "....");
        assertGridEquals(input, Ex06.step(input));
    }

    @Test @Timeout(10)
    void blinkerGenerations() {
        boolean[][] horizontal = grid(".....", ".....", ".###.", ".....", ".....");
        boolean[][] vertical = grid(".....", "..#..", "..#..", "..#..", ".....");
        assertGridEquals(vertical, Ex06.step(horizontal));
        assertGridEquals(horizontal, Ex06.step(vertical));
        assertGridEquals(horizontal, Ex06.run(horizontal, 2));
    }

    @Test @Timeout(10)
    void gliderGenerations() {
        boolean[][] input = grid("........", "..#.....", "...#....", ".###....",
                "........", "........", "........", "........");
        boolean[][] expected = grid("........", "........", "...#....", "....#...",
                "..###...", "........", "........", "........");
        assertGridEquals(expected, Ex06.run(input, 4));
    }

    @Test @Timeout(10)
    void inputAndRows() {
        boolean[][] input = grid(".#..", "..#.", "###.", "....");
        boolean[][] original = grid(".#..", "..#.", "###.", "....");
        boolean[][] result = Ex06.step(input);
        assertGridEquals(original, input);
        assertNotSame(input, result);
        for (boolean[] row : result) for (boolean[] inputRow : input) assertNotSame(inputRow, row);
    }

    @Test @Timeout(10)
    void parseAndRender() {
        String[] rows = {".#..", "##..", "..#."};
        assertGridEquals(grid(rows), Ex06.parse(rows));
        assertArrayEquals(rows, Ex06.render(grid(rows)));
        assertArrayEquals(rows, Ex06.render(Ex06.parse(rows)));
    }

    @Test @Timeout(10)
    void generationComparison() {
        Random random = new Random(106);
        for (int trial = 0; trial < 30; trial++) {
            boolean[][] initial = new boolean[10][12];
            for (boolean[] row : initial) for (int c = 0; c < row.length; c++) row[c] = random.nextBoolean();
            boolean[][] expected = initial;
            for (int i = 0; i < 10; i++) expected = stepReference(expected);
            assertGridEquals(expected, Ex06.run(initial, 10));
        }
    }

    private static boolean[][] grid(String... rows) {
        boolean[][] result = new boolean[rows.length][];
        for (int r = 0; r < rows.length; r++) {
            result[r] = new boolean[rows[r].length()];
            for (int c = 0; c < rows[r].length(); c++) result[r][c] = rows[r].charAt(c) == '#';
        }
        return result;
    }

    private static void assertGridEquals(boolean[][] expected, boolean[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int r = 0; r < expected.length; r++) assertArrayEquals(expected[r], actual[r]);
    }

    private static boolean[][] stepReference(boolean[][] input) {
        int rows = input.length, cols = input[0].length;
        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) {
            if (!input[r][c]) continue;
            for (int nr = Math.max(0, r - 1); nr <= Math.min(rows - 1, r + 1); nr++) {
                for (int nc = Math.max(0, c - 1); nc <= Math.min(cols - 1, c + 1); nc++) {
                    if (nr != r || nc != c) counts[nr][nc]++;
                }
            }
        }
        boolean[][] result = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) {
            result[r][c] = counts[r][c] == 3 || (input[r][c] && counts[r][c] == 2);
        }
        return result;
    }
}
