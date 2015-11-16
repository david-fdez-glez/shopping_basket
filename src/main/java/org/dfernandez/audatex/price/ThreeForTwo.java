package org.dfernandez.audatex.price;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 15/11/15
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class ThreeForTwo implements IPriceStrategy {

    @Override
    public double getPrice(double price, int quantity) {
        return  ((quantity/3)*2  + (quantity%3))*price;
    }

    @Override
    public String toString() {
        return "\n\tThree for the price of two\n";
    }
}
