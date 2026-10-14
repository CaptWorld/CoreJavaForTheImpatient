package ch01.ex06;

/**
 * <pre>
 * Ex06: Game of Life (about 40 minutes)
 *
 * A grid is a rectangular boolean[][] (true = alive). Cells outside the grid are dead.
 *
 * public static boolean[][] parse(String... rows)   // '#' alive, '.' dead, equal-length rows
 * public static String[] render(boolean[][] grid)   // the inverse of parse
 * public static boolean[][] step(boolean[][] grid)
 *    One generation. A live cell with 2 or 3 live neighbors (of its 8) survives;
 *    a dead cell with exactly 3 live neighbors becomes alive; all others are dead.
 *    The argument is not modified, and the result shares no row arrays with it.
 * public static boolean[][] run(boolean[][] grid, int generations)   // generations &gt;= 0
 *
 * Tests:
 *   a 4x4 block ("....", ".##.", ".##.", "....") is unchanged after step;
 *   a blinker in a 5x5 grid alternates between vertical and horizontal, period 2;
 *   the glider below in an 8x8 grid moved by +1 row and +1 column after 4 generations;
 *   step never modifies its argument and returns distinct row arrays;
 *   parse/render round trip; and a randomized comparison (fixed seed, 10x12 grids,
 *   10 generations) with a straightforward reference inside the test.
 *
 * Glider scenario [verified]. Start:
 * ........
 * ..#.....
 * ...#....
 * .###....
 * ........
 * ........
 * ........
 * ........
 *
 * After run(g, 4):
 * ........
 * ........
 * ...#....
 * ....#...
 * ..###...
 * ........
 * ........
 * ........
 * </pre>
 */
public class Ex06 {
    public static boolean[][] parse(String... rows) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String[] render(boolean[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    public static boolean[][] step(boolean[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    public static boolean[][] run(boolean[][] grid, int generations) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you handle the grid border, and what did you consider doing instead?
A1:

Q2: What would have gone wrong if `step` had updated the grid in place?
A2:
*/
