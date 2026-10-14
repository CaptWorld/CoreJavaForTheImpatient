package ch01.ex05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class Ex05Test {
    @Test @Timeout(30)
    void sixSidedRolls() {
        Random random = new Random(12345);
        int[] counts = new int[6];
        for (int i = 0; i < 6000; i++) {
            int value = Ex05.roll("d6", random);
            assertTrue(value >= 1 && value <= 6);
            counts[value - 1]++;
        }
        for (int count : counts) assertTrue(count >= 800 && count <= 1200);
    }

    @Test @Timeout(30)
    void threeDiceRolls() {
        Random random = new Random(12345);
        long total = 0;
        for (int i = 0; i < 20000; i++) {
            int value = Ex05.roll("3d6+2", random);
            assertTrue(value >= 5 && value <= 20);
            total += value;
        }
        assertEquals(12.5, total / 20000.0, 0.2);
    }

    @Test @Timeout(10)
    void otherDiceRolls() {
        Random random = new Random(12345);
        for (int i = 0; i < 6000; i++) {
            int a = Ex05.roll("2d8-1", random), b = Ex05.roll("d20", random);
            assertTrue(a >= 1 && a <= 15);
            assertTrue(b >= 1 && b <= 20);
        }
    }

    @Test @Timeout(30)
    void lotteryDraws() {
        Random random = new Random(12345);
        int[] counts = new int[49];
        for (int i = 0; i < 20000; i++) {
            int[] draw = Ex05.draw(6, 49, random);
            assertEquals(6, draw.length);
            int previous = 0;
            for (int value : draw) {
                assertTrue(value >= 1 && value <= 49);
                assertTrue(value > previous);
                counts[value - 1]++;
                previous = value;
            }
        }
        for (int count : counts) assertTrue(count >= 2150 && count <= 2750);
    }

    @Test @Timeout(10)
    void smallDraws() {
        Random random = new Random(12345);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, Ex05.draw(5, 5, random));
        for (int i = 0; i < 100; i++) {
            int[] draw = Ex05.draw(1, 3, random);
            assertEquals(1, draw.length);
            assertTrue(draw[0] >= 1 && draw[0] <= 3);
        }
    }

    @Test @Timeout(10)
    void identifierLengths() {
        Random random = new Random(12345);
        for (int length : new int[] {1, 8, 13, 40}) {
            String id = Ex05.randomId(length, random);
            assertEquals(length, id.length());
            assertTrue(id.matches("[0-9a-z]+"));
        }
    }

    @Test @Timeout(30)
    void identifierPositions() {
        Random random = new Random(12345);
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        int[][] counts = new int[8][36];
        for (int i = 0; i < 36000; i++) {
            String id = Ex05.randomId(8, random);
            assertEquals(8, id.length());
            for (int position = 0; position < 8; position++) {
                int index = alphabet.indexOf(id.charAt(position));
                assertTrue(index >= 0);
                counts[position][index]++;
            }
        }
        for (int[] position : counts) for (int count : position) assertTrue(count >= 700 && count <= 1300);
    }
}
