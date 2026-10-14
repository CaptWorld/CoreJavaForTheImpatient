package ch01.ex05;

import java.util.random.RandomGenerator;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex05 {
    public static int roll(String expr, RandomGenerator rng) {
        int d = expr.indexOf('d');
        int count = d == 0 ? 1 : Integer.parseInt(expr.substring(0, d));
        int end = d + 1;
        while (end < expr.length() && Character.isDigit(expr.charAt(end))) end++;
        int faces = Integer.parseInt(expr.substring(d + 1, end));
        int result = end == expr.length() ? 0 : Integer.parseInt(expr.substring(end));
        for (int i = 0; i < count; i++) result += rng.nextInt(faces) + 1;
        return result;
    }

    public static int[] draw(int count, int max, RandomGenerator rng) {
        ArrayList<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= max; i++) pool.add(i);
        int[] result = new int[count];
        for (int i = 0; i < count; i++) result[i] = pool.remove(rng.nextInt(pool.size()));
        Arrays.sort(result);
        return result;
    }

    public static String randomId(int length, RandomGenerator rng) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) result.append(Long.toString(rng.nextLong(36L), 36));
        return result.toString();
    }
}
