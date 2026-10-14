package ch01.ex07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class Ex07Test {
    @Test @Timeout(10)
    void threeByThree() {
        assertGridEquals(new int[][] {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}, Ex07.siamese(3));
    }

    @Test @Timeout(10)
    void generatedSquares() {
        assertGridEquals(new int[][] {{17, 24, 1, 8, 15}, {23, 5, 7, 14, 16},
                {4, 6, 13, 20, 22}, {10, 12, 19, 21, 3}, {11, 18, 25, 2, 9}}, Ex07.siamese(5));
        for (int n : new int[] {3, 5, 7, 9, 11}) {
            int[][] square = Ex07.siamese(n);
            assertEquals(n, square.length);
            boolean[] seen = new boolean[n * n + 1];
            long expectedSum = (long) n * (n * n + 1) / 2;
            long diagonal = 0, otherDiagonal = 0;
            for (int r = 0; r < n; r++) {
                assertEquals(n, square[r].length);
                long rowSum = 0, colSum = 0;
                for (int c = 0; c < n; c++) {
                    int value = square[r][c];
                    assertTrue(value >= 1 && value <= n * n);
                    assertFalse(seen[value]);
                    seen[value] = true;
                    rowSum += value;
                    colSum += square[c][r];
                }
                assertEquals(expectedSum, rowSum);
                assertEquals(expectedSum, colSum);
                diagonal += square[r][r];
                otherDiagonal += square[r][n - 1 - r];
            }
            assertEquals(expectedSum, diagonal);
            assertEquals(expectedSum, otherDiagonal);
            assertTrue(Ex07.isMagic(square));
        }
    }

    @Test @Timeout(10)
    void squareScenarios() {
        assertTrue(Ex07.isMagic(bookSquare()));
        int[][] swapped = bookSquare();
        int temp = swapped[0][0];
        swapped[0][0] = swapped[0][1];
        swapped[0][1] = temp;
        assertFalse(Ex07.isMagic(swapped));
        assertFalse(Ex07.isMagic(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        assertFalse(Ex07.isMagic(new int[][] {{8, 1, 6}, {3, 5}, {4, 9, 2}}));
    }

    @Test @Timeout(10)
    void bookInput() {
        assertEquals("Magic square (sum 34)\n", output("16 3 2 13\n5 10 11 8\n9 6 7 12\n4 15 14 1\n\n"));
    }

    @Test @Timeout(10)
    void otherInputs() {
        assertEquals("Not a magic square\n", output("1 2\n3 4\n"));
        assertEquals("Not a magic square\n", output("8 1 6\n3 5\n4 9 2\n\n"));
    }

    private static int[][] bookSquare() {
        return new int[][] {{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}};
    }

    private static String output(String input) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        Ex07.run(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), new PrintStream(bytes, true, StandardCharsets.UTF_8));
        return bytes.toString(StandardCharsets.UTF_8);
    }

    private static void assertGridEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int r = 0; r < expected.length; r++) assertArrayEquals(expected[r], actual[r]);
    }
}
