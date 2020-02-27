/**
 * The purchase class
 *
 * @author Frederick Stallmeyer
 * @version 1.0
 */
import Goods.*;

import java.util.ArrayList;

public class Purchase {

    double wallet;
    double purchaseSum;
    String salesCheck;
    ArrayList<BasketGood> basketGoods;

    /**
     * Format three columns for the sales check.
     *
     * @return Amount of money left after purchase in the wallet
     */
    private String columnize(String col1, String col2, String col3) {
        return String.format("%-10s %4s %14s", col1, col2, col3);
    }

    /**
     * Sum the shopping basket and prepair the sales check.
     */
    public void makeSalesCheck() {
        double multiplierPrice = 0.0;

        for (BasketGood basketGood : basketGoods) {
            multiplierPrice = basketGood.getAmount() * basketGood.getGood().getPrice();
            salesCheck += columnize(basketGood.getGood().getName(), basketGood.getAmount() + " x",
                    FormatPrice.formatPrice(basketGood.getGood().getPrice()) + " EUR\n");
            salesCheck += columnize("", "", FormatPrice.formatPrice(multiplierPrice) + " EUR\n");
            purchaseSum += multiplierPrice;
        }
    }

    /**
     * Execute the purchase.
     *
     * @return Amount of money left after purchase in the wallet
     */
    public double execute() {
        makeSalesCheck();

        if (purchaseSum > wallet) {
            System.out.print("Not enough money in the wallet. Missing: " + FormatPrice.formatPrice(purchaseSum - wallet) + " EUR\n");
        }
        else {
            salesCheck += "-".repeat(10 + 1 + 4 + 1 + 13) + "\n";
            salesCheck += columnize("Sum:", "", FormatPrice.formatPrice(purchaseSum) + " EUR\n");
            salesCheck += columnize("Given:", "", FormatPrice.formatPrice(wallet) + " EUR\n");
            salesCheck += columnize("Return:", "", FormatPrice.formatPrice(wallet - purchaseSum) + " EUR\n");
            System.out.printf(salesCheck);
            wallet -= purchaseSum;
        }

        return this.wallet;
    }

    /**
     * Prepair the purchase.
     *
     * @param wallet Amount of money in the wallet
     */
    public Purchase(double wallet) {
        this.wallet = wallet;
        this.salesCheck = "";

        basketGoods = new ArrayList<BasketGood>();
        basketGoods.add(new BasketGood(new Sausage(), 1));
        basketGoods.add(new BasketGood(new Bread(), 1));
        basketGoods.add(new BasketGood(new Cheese(), 1));
        basketGoods.add(new BasketGood(new TV(), 1));

        BasketGood dvdGood = new BasketGood(new DVD(), 1);

        basketGoods.add(dvdGood);

        dvdGood.setAmount(dvdGood.getAmount() + 1);
    }
}
