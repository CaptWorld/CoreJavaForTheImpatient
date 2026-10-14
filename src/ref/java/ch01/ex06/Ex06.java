package ch01.ex06;

public class Ex06 {
    public static boolean[][] parse(String... rows) {
        boolean[][] result = new boolean[rows.length][];
        for (int r = 0; r < rows.length; r++) {
            result[r] = new boolean[rows[r].length()];
            for (int c = 0; c < rows[r].length(); c++) result[r][c] = rows[r].charAt(c) == '#';
        }
        return result;
    }

    public static String[] render(boolean[][] grid) {
        String[] result = new String[grid.length];
        for (int r = 0; r < grid.length; r++) {
            StringBuilder line = new StringBuilder();
            for (boolean cell : grid[r]) line.append(cell ? '#' : '.');
            result[r] = line.toString();
        }
        return result;
    }

    public static boolean[][] step(boolean[][] grid) {
        boolean[][] result = new boolean[grid.length][];
        for (int r = 0; r < grid.length; r++) {
            result[r] = new boolean[grid[r].length];
            for (int c = 0; c < grid[r].length; c++) {
                int neighbors = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int row = r + dr, col = c + dc;
                        if ((dr != 0 || dc != 0) && row >= 0 && row < grid.length
                                && col >= 0 && col < grid[row].length && grid[row][col]) neighbors++;
                    }
                }
                result[r][c] = neighbors == 3 || (grid[r][c] && neighbors == 2);
            }
        }
        return result;
    }

    public static boolean[][] run(boolean[][] grid, int generations) {
        boolean[][] result = grid;
        for (int i = 0; i < generations; i++) result = step(result);
        return result;
    }
}
