/**
 * Format prices to fixed two digits after comma
 *
 * @author fs - Frederick Stallmeyer
 * @version 1.0
 */

public class FormatPrice {

    public static String formatPrice(double price) {
        double round = Math.round(price * 100.0) / 100.0;
        return String.format("%.2f", round);
    }

}
