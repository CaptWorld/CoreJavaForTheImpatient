package ch01.ex10;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * <pre>
 * Ex10: Mini grep (about 35 minutes)
 *
 * public static void run(String[] args, InputStream in, PrintStream out)
 *    args: zero or more options followed by one pattern. Options are "-i", "-n" and "-c", in any
 *    order, each given as its own argument (no combined flags like "-in").
 *    Reads all lines from `in`; a line matches if it contains the pattern as a plain substring
 *    ("-i": ignoring case; the tests use ASCII only).
 *    Default: print each matching line followed by "\n".
 *    "-n": print each matching line as "&lt;line number&gt;:&lt;line&gt;" (line numbers start at 1 and count all lines).
 *    "-c": print only the number of matching lines, followed by "\n" (it wins over "-n").
 *    main(String[] args) calls run(args, System.in, System.out).
 *
 * Tests (input below; plus a randomized check with a fixed seed that the number printed by "-c" equals
 * the number of lines printed without it):
 *
 * Input used in the tests (4 lines): Hello World, hello again, nothing here, HELLO!
 * args -&gt; output (each output line ends in a newline):
 * {"hello"} -&gt; hello again
 * {"-i","hello"} -&gt; Hello World; hello again; HELLO!
 * {"-n","-i","hello"} -&gt; 1:Hello World; 2:hello again; 4:HELLO!
 * {"-c","-i","hello"} -&gt; 3
 * {"-c","-n","zzz"} -&gt; 0
 * {"-i","o"} -&gt; Hello World; hello again; nothing here; HELLO!
 * </pre>
 */
public class Ex10 {
    public static void run(String[] args, InputStream in, PrintStream out) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run(args, System.in, System.out);
    }
}

/* MY NOTES
Actual time: ___ min

Q1: How did you separate options from the pattern, and what is the simplest thing that would break your approach?
A1:

Q2: How did you read the input (which class, which method), and what would change for a 2 GB file?
A2:
*/
