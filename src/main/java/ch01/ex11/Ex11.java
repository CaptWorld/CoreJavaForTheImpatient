package ch01.ex11;

/**
 * <pre>
 * Ex11: Sudoku checker (about 35 minutes)
 *
 * A grid is an int[9][9]; 0 means empty, 1..9 are digits.
 *
 * public static int[] firstConflict(int[][] grid)
 *    Scans cells in row-major order. A non-empty cell conflicts if an EARLIER non-empty cell in
 *    the same row, the same column or the same 3x3 box holds the same digit. Returns { row, col }
 *    of the first conflicting cell, or an empty array if there is none.
 * public static boolean isValid(int[][] grid)         // no conflicts
 * public static int[] candidates(int[][] grid, int row, int col)
 *    For an empty cell: the digits (ascending) that appear in none of its row, column and box.
 *
 * Tests: a solved grid built in the test with g[r][c] = (3 * (r % 3) + r / 3 + c) % 9 + 1 is valid;
 * the three corrupted scenarios below; firstConflict compared with a brute-force reference inside
 * the test on random corruptions (fixed seed); candidates of a cell emptied from the solved grid is
 * exactly the emptied digit; candidates compared with a reference on partly emptied grids.
 *
 * Scenarios [verified], starting from the solved grid:
 * set g[4][4] = g[4][0] -&gt; {4,4}; set g[8][8] = g[0][8] -&gt; {8,8};
 * set g[1][1] = g[0][0] -&gt; {1,1}.
 * </pre>
 */
public class Ex11 {
    public static int[] firstConflict(int[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    public static boolean isValid(int[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int[] candidates(int[][] grid, int row, int col) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you walk the box of a cell, and what did you try before that?
A1:

Q2: Where did a labeled `break`/`continue` (or a way to avoid one) come up, and which did you choose?
A2:
*/
