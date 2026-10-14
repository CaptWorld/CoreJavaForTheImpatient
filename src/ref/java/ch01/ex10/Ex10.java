package ch01.ex10;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Locale;

public class Ex10 {
    public static void run(String[] args, InputStream in, PrintStream out) {
        boolean insensitive = false, numbers = false, countOnly = false;
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-i" -> insensitive = true;
                case "-n" -> numbers = true;
                case "-c" -> countOnly = true;
                default -> throw new IllegalArgumentException(args[i]);
            }
        }
        String pattern = args[args.length - 1];
        if (insensitive) pattern = pattern.toLowerCase(Locale.ROOT);
        Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);
        int lineNumber = 0, count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            String compared = insensitive ? line.toLowerCase(Locale.ROOT) : line;
            if (compared.contains(pattern)) {
                count++;
                if (!countOnly) out.print((numbers ? lineNumber + ":" : "") + line + "\n");
            }
        }
        if (countOnly) out.print(count + "\n");
    }

    public static void main(String[] args) {
        run(args, System.in, System.out);
    }
}
