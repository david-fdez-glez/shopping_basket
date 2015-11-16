package org.dfernandez.audatex.model;

import org.dfernandez.audatex.price.IPriceStrategy;
import org.dfernandez.audatex.price.NormalPrice;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 12/11/15
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class Item {

    private String name;
    private double price;
    private int quantity;
    private IPriceStrategy strategy;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.strategy = new NormalPrice();
    }

    public Item(String name, double price, IPriceStrategy strategy) {
        this.name = name;
        this.price = price;
        this.strategy = strategy;
        this.quantity = 1;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStrategy(IPriceStrategy strategy) {
        this.strategy = strategy;
    }

    public double getTotalPrice() {
        return strategy.getPrice(this.getPrice(), this.getQuantity()) ;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        final Item itemCompare = (Item) obj;
        if(!this.name.equals(itemCompare.getName()))  {
            return  false;
        }

        if(this.quantity != itemCompare.quantity) {
            return  false;
        }

        if(this.price != itemCompare.getPrice()) {
            return  false;
        }
        if(this.strategy.getClass() != itemCompare.strategy.getClass()) {
            return false;
        }
        if(this.getTotalPrice() != itemCompare.getTotalPrice()) {
            return false;
        }
        return  true;
    }

    @Override
    public String toString() {
        return name +" qty " + quantity + " price item " + price  + " total " +getTotalPrice()
                +strategy.toString();
    }
}
