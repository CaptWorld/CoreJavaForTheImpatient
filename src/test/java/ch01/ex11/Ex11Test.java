package ch01.ex11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.ArrayList;

class Ex11Test {
    @Test @Timeout(10)
    void solvedGrid() {
        assertArrayEquals(new int[0], Ex11.firstConflict(solved()));
        assertTrue(Ex11.isValid(solved()));
    }

    @Test @Timeout(10)
    void conflictScenarios() {
        int[][] a = solved();
        a[4][4] = a[4][0];
        assertArrayEquals(new int[] {4, 4}, Ex11.firstConflict(a));
        assertFalse(Ex11.isValid(a));
        int[][] b = solved();
        b[8][8] = b[0][8];
        assertArrayEquals(new int[] {8, 8}, Ex11.firstConflict(b));
        assertFalse(Ex11.isValid(b));
        int[][] c = solved();
        c[1][1] = c[0][0];
        assertArrayEquals(new int[] {1, 1}, Ex11.firstConflict(c));
        assertFalse(Ex11.isValid(c));
    }

    @Test @Timeout(10)
    void conflictComparison() {
        Random random = new Random(111);
        for (int trial = 0; trial < 300; trial++) {
            int[][] grid = solved();
            int changes = 1 + random.nextInt(8);
            for (int i = 0; i < changes; i++) grid[random.nextInt(9)][random.nextInt(9)] = 1 + random.nextInt(9);
            int[] expected = conflictReference(grid);
            assertArrayEquals(expected, Ex11.firstConflict(grid));
            assertEquals(expected.length == 0, Ex11.isValid(grid));
        }
    }

    @Test @Timeout(10)
    void singleEmptyCell() {
        for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) {
            int[][] grid = solved();
            int digit = grid[r][c];
            grid[r][c] = 0;
            assertArrayEquals(new int[] {digit}, Ex11.candidates(grid, r, c));
        }
    }

    @Test @Timeout(10)
    void candidateComparison() {
        Random random = new Random(211);
        for (int trial = 0; trial < 100; trial++) {
            int[][] grid = solved();
            for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) {
                if (random.nextBoolean()) grid[r][c] = 0;
            }
            for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) {
                if (grid[r][c] == 0) assertArrayEquals(candidateReference(grid, r, c), Ex11.candidates(grid, r, c));
            }
        }
    }

    private static int[][] solved() {
        int[][] grid = new int[9][9];
        for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) grid[r][c] = (3 * (r % 3) + r / 3 + c) % 9 + 1;
        return grid;
    }

    private static int[] conflictReference(int[][] grid) {
        for (int index = 0; index < 81; index++) {
            int r = index / 9, c = index % 9;
            if (grid[r][c] == 0) continue;
            for (int previous = 0; previous < index; previous++) {
                int pr = previous / 9, pc = previous % 9;
                if (grid[r][c] == grid[pr][pc] && (r == pr || c == pc || (r / 3 == pr / 3 && c / 3 == pc / 3))) {
                    return new int[] {r, c};
                }
            }
        }
        return new int[0];
    }

    private static int[] candidateReference(int[][] grid, int row, int col) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int digit = 1; digit <= 9; digit++) {
            boolean present = false;
            for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) {
                if ((r == row || c == col || (r / 3 == row / 3 && c / 3 == col / 3)) && grid[r][c] == digit) present = true;
            }
            if (!present) result.add(digit);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
