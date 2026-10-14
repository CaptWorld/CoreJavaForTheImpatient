package ch01.ex02;

/**
 * <pre>
 * Ex02: Compass walker (warm-up, about 25 minutes)
 *
 * A walker starts at (0,0) facing north (heading 0). Headings are clockwise
 * degrees: 0 = N, 90 = E, 180 = S, 270 = W. North is +y, east is +x.
 *
 * public static int[] offset(String dir)
 *    "N" -&gt; {0,1}, "S" -&gt; {0,-1}, "E" -&gt; {1,0}, "W" -&gt; {-1,0}.
 *    Self-policed: write it as a switch expression.
 *
 * public static String compass(int heading)
 *    heading is any multiple of 90 (positive or negative, any size).
 *    Returns "N", "E", "S" or "W". compass(-90) -&gt; "W", compass(450) -&gt; "E".
 *
 * public static int[] walk(String commands)
 *    commands are separated by single spaces: "F&lt;n&gt;" (forward n cells),
 *    "L&lt;d&gt;" (turn left d degrees), "R&lt;d&gt;" (turn right d degrees); d is a
 *    non-negative multiple of 90 of any size, n is a non-negative integer.
 *    Returns { x, y, heading } where heading is normalized to 0..359.
 *    Examples: "F3 R90 F2" -&gt; {2,3,90}; "L90 F1" -&gt; {-1,0,270}.
 *
 * Tests: offset table; compass for -720, -180, -90, 450; five walk scenarios;
 * invariant "L&lt;d&gt; R&lt;d&gt; changes nothing"; randomized command lists (fixed seed)
 * compared with a reference that turns in separate 90-degree steps.
 *
 * Exact values [verified]:
 * walk("R450 F2 L90 F1") -&gt; {2,1,0}
 * walk("L90 L90 L90 F4") -&gt; {4,0,90}
 * walk("F5 R180 F2 L270 F1") -&gt; {-1,3,270}
 * compass(-720), compass(-180) -&gt; "N", "S"
 * </pre>
 */
public class Ex02 {
    public static int[] offset(String dir) {
        throw new UnsupportedOperationException("TODO");
    }

    public static String compass(int heading) {
        throw new UnsupportedOperationException("TODO");
    }

    public static int[] walk(String commands) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you keep the heading in range, and which alternatives did you try?
A1:

Q2: What did you decide to do with the `switch` in `walk`, and why?
A2:
*/
