package ch01.ex07;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.ArrayList;

public class Ex07 {
    public static boolean isMagic(int[][] m) {
        int n = m.length;
        for (int[] row : m) if (row.length != n) return false;
        long sum = 0;
        for (int value : m[0]) sum += value;
        long firstDiagonal = 0, secondDiagonal = 0;
        for (int r = 0; r < n; r++) {
            long rowSum = 0, colSum = 0;
            for (int c = 0; c < n; c++) {
                rowSum += m[r][c];
                colSum += m[c][r];
            }
            if (rowSum != sum || colSum != sum) return false;
            firstDiagonal += m[r][r];
            secondDiagonal += m[r][n - 1 - r];
        }
        return firstDiagonal == sum && secondDiagonal == sum;
    }

    public static int[][] siamese(int n) {
        int[][] result = new int[n][n];
        int row = 0, col = n / 2;
        for (int value = 1; value <= n * n; value++) {
            result[row][col] = value;
            int nextRow = Math.floorMod(row - 1, n), nextCol = (col + 1) % n;
            if (result[nextRow][nextCol] != 0) row = (row + 1) % n;
            else {
                row = nextRow;
                col = nextCol;
            }
        }
        return result;
    }

    public static void run(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);
        ArrayList<int[]> rows = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            String[] tokens = line.trim().split("\\s+");
            int[] row = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) row[i] = Integer.parseInt(tokens[i]);
            rows.add(row);
        }
        int[][] square = rows.toArray(new int[0][]);
        if (isMagic(square)) {
            long sum = 0;
            for (int value : square[0]) sum += value;
            out.print("Magic square (sum " + sum + ")\n");
        } else out.print("Not a magic square\n");
    }

    public static void main(String[] args) {
        run(System.in, System.out);
    }
}
