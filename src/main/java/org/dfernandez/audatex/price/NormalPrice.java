package org.dfernandez.audatex.price;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 15/11/15
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class NormalPrice implements IPriceStrategy {

    @Override
    public double getPrice(double price, int quantity) {
        return price*quantity;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return "";
    }
}
