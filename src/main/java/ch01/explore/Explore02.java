package ch01.explore;

/**
 * <pre>
 * Explore02: String-building race (about 20 to 45 minutes; skippable)
 * after Ex03, Ex04; section 1.5.1
 *
 * Open investigation, not an exercise. Write the experiment in main, run it,
 * and record what you saw in MY NOTES. Make a prediction in the notes before
 * you run anything. Shell commands and timing tables also go in the notes.
 *
 * Build a string of n numbers separated by commas for n = 10^3, 10^4, 10^5 and
 * 10^6 using += in a loop, StringBuilder, String.join, and a StringJoiner.
 * Time each with hyperfine (use the same warm-up and run counts) and put the
 * table in the notes.
 * </pre>
 */
public class Explore02 {
    public static void main(String[] args) {
        // TODO
    }
}

/* MY NOTES
Actual time: ___ min

Prediction (write before running):


Q1: At which n did the winner and the loser separate by more than 10x, and how does the growth of the slow version look (linear, quadratic)?
A1:

Q2: When does the compiler already rewrite concatenation for you, and what did you do to check that?
A2:
*/
