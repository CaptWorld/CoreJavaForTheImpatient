package ch01.ex03;

import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
    public static String receipt(String[] items, String taxPercent, Locale locale) {
        StringBuilder result = new StringBuilder("""
                RECEIPT
                ==========================================
                """);
        BigDecimal subtotal = BigDecimal.ZERO;
        for (String item : items) {
            String[] fields = item.split(",");
            int quantity = Integer.parseInt(fields[1]);
            BigDecimal price = new BigDecimal(fields[2]);
            BigDecimal line = price.multiply(BigDecimal.valueOf(quantity));
            subtotal = subtotal.add(line);
            result.append(String.format(locale, "%-16s%4d%,10.2f%,12.2f\n", fields[0], quantity, price, line));
        }
        BigDecimal tax = subtotal.multiply(new BigDecimal(taxPercent)).movePointLeft(2)
                .setScale(2, RoundingMode.HALF_UP);
        result.append("------------------------------------------\n");
        result.append(String.format(locale, "%-30s%,12.2f\n", "Subtotal", subtotal));
        result.append(String.format(locale, "%-30s%,12.2f\n", "Tax (" + taxPercent + "%)", tax));
        result.append(String.format(locale, "%-30s%,12.2f\n", "TOTAL", subtotal.add(tax)));
        return result.toString();
    }
}
