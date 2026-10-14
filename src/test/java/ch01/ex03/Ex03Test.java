package ch01.ex03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Random;

class Ex03Test {
    @Test @Timeout(10)
    void shoppingReceipt() {
        String expected = """
                RECEIPT
                ==========================================
                Notebook___________3______4.99_______14.97
                Pen_(blue)________12______0.10________1.20
                USB_cable__________2__1,299.50____2,599.00
                Bolt____________12000______0.07______840.00
                ------------------------------------------
                Subtotal__________________________3,455.17
                Tax_(8.25%)_________________________285.05
                TOTAL_____________________________3,740.22
                """.replace('_', ' ');
        assertEquals(expected, Ex03.receipt(new String[] {"Notebook,3,4.99", "Pen (blue),12,0.10",
                "USB cable,2,1299.50", "Bolt,12000,0.07"}, "8.25", Locale.US));
    }

    @Test @Timeout(10)
    void gumReceiptUs() {
        String expected = """
                RECEIPT
                ==========================================
                Gum                6      1.00        6.00
                ------------------------------------------
                Subtotal                              6.00
                Tax (8.25%)                           0.50
                TOTAL                                 6.50
                """;
        assertEquals(expected, Ex03.receipt(new String[] {"Gum,6,1.00"}, "8.25", Locale.US));
    }

    @Test @Timeout(10)
    void gumReceiptGermany() {
        String expected = """
                RECEIPT
                ==========================================
                Gum                6      1,00        6,00
                ------------------------------------------
                Subtotal                              6,00
                Tax (8.25%)                           0,50
                TOTAL                                 6,50
                """;
        assertEquals(expected, Ex03.receipt(new String[] {"Gum,6,1.00"}, "8.25", Locale.GERMANY));
    }

    @Test @Timeout(10)
    void cableReceipt() {
        String expected = """
                RECEIPT
                ==========================================
                Cable              2    130.70      261.40
                ------------------------------------------
                Subtotal                            261.40
                Tax (7.5%)                           19.61
                TOTAL                               281.01
                """;
        assertEquals(expected, Ex03.receipt(new String[] {"Cable,2,130.70"}, "7.5", Locale.US));
    }

    @Test @Timeout(10)
    void mouseReceipt() {
        String expected = """
                RECEIPT
                ==========================================
                Mouse              1    529.80      529.80
                ------------------------------------------
                Subtotal                            529.80
                Tax (7.5%)                           39.74
                TOTAL                               569.54
                """;
        assertEquals(expected, Ex03.receipt(new String[] {"Mouse,1,529.80"}, "7.5", Locale.US));
    }

    @Test @Timeout(10)
    void twentyItemComparison() {
        String[] items = new String[20];
        String[] prices = {"0.10", "0.20", "0.30"};
        for (int i = 0; i < items.length; i++) items[i] = "Item " + (i + 1) + "," + (5000 * (i + 1)) + "," + prices[i % 3];
        verifyReceipt(items, "8.25", Ex03.receipt(items, "8.25", Locale.US));
    }

    @Test @Timeout(10)
    void randomReceiptComparison() {
        Random random = new Random(103);
        String[] rates = {"7.5", "8.25", "6.25"};
        for (int i = 0; i < 300; i++) {
            String price = BigDecimal.valueOf(1 + random.nextInt(99999), 2).toPlainString();
            String[] items = {"Item," + (1 + random.nextInt(9)) + "," + price};
            String rate = rates[i % rates.length];
            verifyReceipt(items, rate, Ex03.receipt(items, rate, Locale.US));
        }
    }

    private static void verifyReceipt(String[] items, String rate, String receipt) {
        assertTrue(receipt.endsWith("\n"));
        String[] lines = receipt.lines().toArray(String[]::new);
        assertEquals(items.length + 6, lines.length);
        assertEquals("RECEIPT", lines[0]);
        assertEquals("=".repeat(42), lines[1]);
        BigDecimal subtotal = BigDecimal.ZERO;
        for (int i = 0; i < items.length; i++) {
            String[] input = items[i].split(",");
            String row = lines[i + 2];
            assertEquals(input[0], row.substring(0, 16).stripTrailing());
            String[] columns = row.substring(16).trim().split("\\s+");
            assertEquals(3, columns.length);
            int quantity = Integer.parseInt(input[1]);
            assertEquals(quantity, Integer.parseInt(columns[0]));
            BigDecimal price = new BigDecimal(input[2]);
            BigDecimal line = price.multiply(BigDecimal.valueOf(quantity));
            assertEquals(0, price.compareTo(money(columns[1])));
            assertEquals(0, line.compareTo(money(columns[2])));
            subtotal = subtotal.add(line);
        }
        assertEquals("-".repeat(42), lines[items.length + 2]);
        BigDecimal tax = subtotal.multiply(new BigDecimal(rate)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        String[] labels = {"Subtotal", "Tax (" + rate + "%)", "TOTAL"};
        BigDecimal[] expected = {subtotal, tax, subtotal.add(tax)};
        for (int i = 0; i < 3; i++) {
            String line = lines[items.length + 3 + i];
            assertEquals(labels[i], line.substring(0, 30).stripTrailing());
            assertEquals(0, expected[i].compareTo(money(line.substring(30).trim())));
        }
    }

    private static BigDecimal money(String value) {
        return new BigDecimal(value.replace(",", ""));
    }
}
