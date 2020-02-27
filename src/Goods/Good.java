/**
 * General goodsclass
 *
 * @author Frederick Stallmeyer
 * @version 1.0
 */
package Goods;

public abstract class Good {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
