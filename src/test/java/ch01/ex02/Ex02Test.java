package ch01.ex02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.StringJoiner;

class Ex02Test {
    @Test @Timeout(10)
    void directionOffsets() {
        assertArrayEquals(new int[] {0, 1}, Ex02.offset("N"));
        assertArrayEquals(new int[] {0, -1}, Ex02.offset("S"));
        assertArrayEquals(new int[] {1, 0}, Ex02.offset("E"));
        assertArrayEquals(new int[] {-1, 0}, Ex02.offset("W"));
    }

    @Test @Timeout(10)
    void compassHeadings() {
        assertEquals("N", Ex02.compass(-720));
        assertEquals("S", Ex02.compass(-180));
        assertEquals("W", Ex02.compass(-90));
        assertEquals("E", Ex02.compass(450));
    }

    @Test @Timeout(10)
    void walkingScenarios() {
        assertArrayEquals(new int[] {2, 3, 90}, Ex02.walk("F3 R90 F2"));
        assertArrayEquals(new int[] {-1, 0, 270}, Ex02.walk("L90 F1"));
        assertArrayEquals(new int[] {2, 1, 0}, Ex02.walk("R450 F2 L90 F1"));
        assertArrayEquals(new int[] {4, 0, 90}, Ex02.walk("L90 L90 L90 F4"));
        assertArrayEquals(new int[] {-1, 3, 270}, Ex02.walk("F5 R180 F2 L270 F1"));
    }

    @Test @Timeout(10)
    void pairedTurns() {
        Random random = new Random(102);
        for (int i = 0; i < 200; i++) {
            String commands = "F3 R90 F2";
            int degrees = 90 * random.nextInt(10000);
            assertArrayEquals(new int[] {2, 3, 90}, Ex02.walk(commands + " L" + degrees + " R" + degrees));
        }
    }

    @Test @Timeout(10)
    void walkingComparison() {
        Random random = new Random(202);
        for (int trial = 0; trial < 200; trial++) {
            StringJoiner commands = new StringJoiner(" ");
            for (int i = 0; i < 30; i++) {
                int type = random.nextInt(3);
                commands.add(type == 0 ? "F" + random.nextInt(21)
                        : (type == 1 ? "L" : "R") + (90 * random.nextInt(13)));
            }
            String input = commands.toString();
            assertArrayEquals(walkReference(input), Ex02.walk(input));
        }
    }

    private static int[] walkReference(String commands) {
        int x = 0, y = 0, dx = 0, dy = 1;
        for (String command : commands.split(" ")) {
            int value = Integer.parseInt(command.substring(1));
            if (command.charAt(0) == 'F') {
                x += dx * value;
                y += dy * value;
            } else {
                for (int i = 0; i < value / 90; i++) {
                    int previousX = dx;
                    dx = command.charAt(0) == 'R' ? dy : -dy;
                    dy = command.charAt(0) == 'R' ? -previousX : previousX;
                }
            }
        }
        int heading = dy == 1 ? 0 : dx == 1 ? 90 : dy == -1 ? 180 : 270;
        return new int[] {x, y, heading};
    }
}
