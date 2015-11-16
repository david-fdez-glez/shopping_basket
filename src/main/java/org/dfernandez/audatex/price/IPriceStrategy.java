package org.dfernandez.audatex.price;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 15/11/15
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public interface IPriceStrategy {

    public double getPrice(double price, int quantity);
}
