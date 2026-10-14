package ch01.ex05;

import java.util.random.RandomGenerator;

/**
 * <pre>
 * Ex05: Random draws (about 40 minutes)
 *
 * All randomness comes from the RandomGenerator parameter (self-policed: do not use
 * Math.random or create your own generator).
 *
 * public static int roll(String expr, RandomGenerator rng)
 *    expr has the form "NdM", "dM", "NdM+K" or "NdM-K": N dice (default 1, at most 100),
 *    each with faces 1..M (M &gt;= 2), plus or minus the modifier K.
 *    "3d6+2" is the sum of three d6 plus 2; "d20" is one d20; "2d8-1" is two d8 minus 1.
 *
 * public static int[] draw(int count, int max, RandomGenerator rng)
 *    Lottery draw: count distinct numbers from 1..max (1 &lt;= count &lt;= max),
 *    returned in ascending order.
 *    Self-policed: start from an ArrayList&lt;Integer&gt; holding 1..max, repeatedly pick a
 *    random position and remove that element, as the book's exercise says.
 *
 * public static String randomId(int length, RandomGenerator rng)
 *    A string of exactly `length` characters (length 1..40), each one of 0-9 or a-z, with every
 *    character equally likely at every position.
 *    Self-policed: build it by printing random long values in base 36.
 *
 * Tests (fixed seed new Random(12345)):
 *   roll("d6") 6000 times: every face from 1 to 6 appears between 800 and 1200 times;
 *   roll("3d6+2") 20000 times: all values in 5..20 and the mean is within 0.2 of 12.5;
 *   roll("2d8-1") stays inside 1..15; roll("d20") stays inside 1..20.
 *   draw(6, 49): 20000 draws, each draw has 6 distinct ascending values in 1..49,
 *   and each number appears between 2150 and 2750 times in total.
 *   draw(5, 5) is {1,2,3,4,5}; draw(1, 3) always returns one value in 1..3.
 *   randomId: lengths 1, 8, 13 and 40 give exactly that many characters from the allowed set;
 *   for 36000 ids of length 8, each of the 36 characters appears between 700 and 1300 times at
 *   each of the 8 positions.
 * </pre>
 */
public class Ex05 {
    public static int roll(String expr, RandomGenerator rng) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int[] draw(int count, int max, RandomGenerator rng) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String randomId(int length, RandomGenerator rng) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: What is your parsing approach for `roll`, and what input did you decide not to handle?
A1:

Q2: Which `ArrayList` method call took you longest to get right in `draw`, and why?
A2:

Q3: What went wrong in your first version of `randomId`, if anything, and how did you notice?
A3:
*/
