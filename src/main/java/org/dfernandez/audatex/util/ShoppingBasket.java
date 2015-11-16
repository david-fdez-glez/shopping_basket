package org.dfernandez.audatex.util;

import org.dfernandez.audatex.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 12/11/15
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingBasket {


    private Map<String,Item> mapItems;

    public ShoppingBasket() {
        mapItems  = new HashMap<String, Item>();
    }


    public boolean addItem(Item item) {

        if(mapItems.containsKey(item.getName()))  {
            Item actual = mapItems.get(item.getName());
            actual.setQuantity(actual.getQuantity() + item.getQuantity());
            return  false;
        }

        mapItems.put(item.getName(),item)   ;

        return true;
    }


    public double getTotalPrice() {
        double total = 0.0;

        for(Map.Entry<String, Item> entry : mapItems.entrySet()) {
             total+= entry.getValue().getTotalPrice();
        }

        return total;
    }


    public List<Item> getListItems() {
        List<Item> listItems = new ArrayList<Item>(mapItems.values());
        return listItems;
    }

    public String toList() {
        StringBuilder sb = new StringBuilder("");
        String sep = "\n";

        for(Map.Entry<String, Item> entry : mapItems.entrySet()) {
            sb.append(sep).append(entry.getValue().toString()).append(sep);
        }
        sb.append(sep).append("Total:").append(getTotalPrice()).append(sep);
        return sb.toString();
    }


}
