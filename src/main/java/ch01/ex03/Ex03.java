package ch01.ex03;

import java.util.Locale;

/**
 * <pre>
 * Ex03: Receipt formatter (about 35 minutes)
 *
 * public static String receipt(String[] items, String taxPercent, Locale locale)
 *
 * Each item is "name,qty,unitPrice", for example "Notebook,3,4.99":
 * a name of at most 16 characters, a positive integer quantity, and a unit price
 * with exactly two decimals. taxPercent is a decimal string such as "8.25".
 *
 * Money must be exact. line total = qty * unit price. subtotal = sum of the line
 * totals. tax = subtotal * taxPercent / 100, rounded half up to two decimals.
 * total = subtotal + tax.
 *
 * Output is built with a text block for the header and ends with a newline:
 *
 * RECEIPT
 * ==========================================      (42 '=' characters)
 * one line per item: name left-justified in 16, qty right-justified in 4,
 *   unit price right-justified in 10 with 2 decimals, line total right-justified
 *   in 12 with 2 decimals; both money columns use the locale's grouping separators
 * ------------------------------------------      (42 '-' characters)
 * "Subtotal", "Tax (&lt;taxPercent&gt;%)" and "TOTAL": label left-justified in 30,
 *   amount right-justified in 12 with 2 decimals and grouping
 *
 * Example (Locale.US), items {"Gum,6,1.00"}, tax "8.25":
 * RECEIPT
 * ==========================================
 * Gum                6      1.00        6.00
 * ------------------------------------------
 * Subtotal                              6.00
 * Tax (8.25%)                           0.50
 * TOTAL                                 6.50
 *
 * Tests: the exact output of the scenarios below, the Gum example in Locale.GERMANY
 * (decimal comma), and two checks that parse the receipt back into BigDecimal values and
 * compare line totals, subtotal, tax and total with a BigDecimal reference computed inside
 * the test: (a) a list of 20 items priced 0.10, 0.20 and 0.30 with quantities up to 100000;
 * (b) 300 random single-item receipts (fixed seed; prices 0.01..999.99, quantities 1..9,
 * tax rates "7.5", "8.25" and "6.25").
 *
 * Exact scenario [verified], items {"Notebook,3,4.99","Pen (blue),12,0.10",
 * "USB cable,2,1299.50","Bolt,12000,0.07"}, tax "8.25", Locale.US.
 * Spaces shown as '_' here; the real output uses spaces:
 * RECEIPT
 * ==========================================
 * Notebook___________3______4.99_______14.97
 * Pen_(blue)________12______0.10________1.20
 * USB_cable__________2__1,299.50____2,599.00
 * Bolt____________12000______0.07______840.00
 * ------------------------------------------
 * Subtotal__________________________3,455.17
 * Tax_(8.25%)_________________________285.05
 * TOTAL_____________________________3,740.22
 *
 * The German example has the same layout with 1,00, 6,00, 0,50, 6,50 [verified].
 * Rounding scenarios [verified], Locale.US:
 * {"Cable,2,130.70"}, tax "7.5": subtotal 261.40, tax 19.61, total 281.01.
 * {"Mouse,1,529.80"}, tax "7.5": subtotal 529.80, tax 39.74, total 569.54.
 * Both use the same layout as the other receipts.
 * </pre>
 */
public class Ex03 {
    public static String receipt(String[] items, String taxPercent, Locale locale) {
        throw new UnsupportedOperationException("TODO");
    }
}

/* MY NOTES
Actual time: ___ min

Q1: Where did you first see a rounding or exactness problem, and how did you notice it?
A1:

Q2: Which formatting facilities did you consider (`printf`, `formatted`, `NumberFormat`), and which did you keep?
A2:
*/
