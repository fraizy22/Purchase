/**
 * Purchase program
 *
 * @author Frederick Stallmeyer
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        double wallet = 158.0;

        Purchase purchase = new Purchase(wallet);
        wallet = purchase.execute();
    }
}