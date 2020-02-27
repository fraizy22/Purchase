/**
 * Goods in the goodsbasket
 *
 * @author Frederick Stallmeyer
 * @version 1.0
 */
import Goods.Good;

public class BasketGood {

    private Good good;
    private Integer amount;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Creates a good in the basket.
     * @param good
     * @param amount
     */
    public BasketGood(Good good, Integer amount) {
        this.good = good;
        this.amount = amount;
    }
}
