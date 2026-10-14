package ch01.ex07;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * <pre>
 * Ex07: Magic squares (about 35 minutes)
 *
 * A magic square is an n x n array of ints in which every row, every column and
 * both diagonals have the same sum (the numbers do not have to be distinct).
 *
 * public static boolean isMagic(int[][] m)
 *    False for any array that is not square (rows of different length, or the row
 *    count differs from the row length). At least one row is given.
 *
 * public static int[][] siamese(int n)      // n odd, n &gt;= 1
 *    Builds the classic magic square of 1..n*n: put 1 in the top middle cell, then
 *    keep moving one step up and one step right (wrapping around the edges); when
 *    the target cell is already filled, move one step down from the last cell instead.
 *
 * public static void run(InputStream in, PrintStream out)
 *    Reads lines of whitespace-separated integers until a blank line (or the end of
 *    the input), each line being one row, and prints either
 *      "Magic square (sum S)"   or   "Not a magic square".
 *    main(String[]) just calls run(System.in, System.out).
 *
 * Tests: siamese(3) is exactly {{8,1,6},{3,5,7},{4,9,2}}; for n = 3, 5, 7, 9, 11
 * siamese(n) is magic and contains every value 1..n*n once; scenarios for isMagic
 * (the 4x4 square from the book, a square with one swapped pair, a 3x4 array, a ragged array);
 * run with the book's input (4 lines then a blank line) prints "Magic square (sum 34)";
 * run on a non-magic input and on a ragged input prints "Not a magic square".
 *
 * Book square [verified]:
 * 16 3 2 13
 * 5 10 11 8
 * 9 6 7 12
 * 4 15 14 1
 * Sum: 34.
 * siamese(5) [verified]: {{17,24,1,8,15},{23,5,7,14,16},{4,6,13,20,22},
 * {10,12,19,21,3},{11,18,25,2,9}}.
 * </pre>
 */
public class Ex07 {
    public static boolean isMagic(int[][] m) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int[][] siamese(int n) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void run(InputStream in, PrintStream out) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run(System.in, System.out);
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you split a line of input into ints, and what other approaches could work?
A1:

Q2: Which part of `isMagic` did you write first, and what would you restructure if the sums were large?
A2:
*/
