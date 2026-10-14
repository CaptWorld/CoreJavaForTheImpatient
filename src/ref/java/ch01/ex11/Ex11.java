package ch01.ex11;

public class Ex11 {
    public static int[] firstConflict(int[][] grid) {
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10], boxes = new boolean[9][10];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int value = grid[r][c], box = 3 * (r / 3) + c / 3;
                if (value == 0) continue;
                if (rows[r][value] || cols[c][value] || boxes[box][value]) return new int[] {r, c};
                rows[r][value] = cols[c][value] = boxes[box][value] = true;
            }
        }
        return new int[0];
    }

    public static boolean isValid(int[][] grid) {
        return firstConflict(grid).length == 0;
    }

    public static int[] candidates(int[][] grid, int row, int col) {
        boolean[] used = new boolean[10];
        for (int i = 0; i < 9; i++) {
            used[grid[row][i]] = true;
            used[grid[i][col]] = true;
        }
        for (int r = row / 3 * 3; r < row / 3 * 3 + 3; r++) {
            for (int c = col / 3 * 3; c < col / 3 * 3 + 3; c++) used[grid[r][c]] = true;
        }
        int count = 0;
        for (int digit = 1; digit <= 9; digit++) if (!used[digit]) count++;
        int[] result = new int[count];
        for (int digit = 1, index = 0; digit <= 9; digit++) if (!used[digit]) result[index++] = digit;
        return result;
    }
}
