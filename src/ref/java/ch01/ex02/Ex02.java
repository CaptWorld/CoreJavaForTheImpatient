package ch01.ex02;

import java.math.BigInteger;

public class Ex02 {
    public static int[] offset(String dir) {
        return switch (dir) {
            case "N" -> new int[] {0, 1};
            case "S" -> new int[] {0, -1};
            case "E" -> new int[] {1, 0};
            case "W" -> new int[] {-1, 0};
            default -> throw new IllegalArgumentException(dir);
        };
    }

    public static String compass(int heading) {
        return switch (Math.floorMod(heading, 360)) {
            case 0 -> "N";
            case 90 -> "E";
            case 180 -> "S";
            case 270 -> "W";
            default -> throw new IllegalArgumentException(Integer.toString(heading));
        };
    }

    public static int[] walk(String commands) {
        int x = 0, y = 0, heading = 0;
        for (String command : commands.split(" ")) {
            switch (command.charAt(0)) {
                case 'F' -> {
                    int distance = Integer.parseInt(command.substring(1));
                    int[] direction = offset(compass(heading));
                    x += distance * direction[0];
                    y += distance * direction[1];
                }
                case 'L', 'R' -> {
                    int turn = new BigInteger(command.substring(1)).mod(BigInteger.valueOf(360)).intValue();
                    heading = Math.floorMod(heading + (command.charAt(0) == 'L' ? -turn : turn), 360);
                }
                default -> throw new IllegalArgumentException(command);
            }
        }
        return new int[] {x, y, heading};
    }
}
