package org.dfernandez.audatex;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

import org.dfernandez.audatex.price.ThreeForTwo;
import org.junit.*;

import org.dfernandez.audatex.model.Item;
import org.dfernandez.audatex.util.ShoppingBasket;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    Item apple ;
    Item banana;
    Item papaya;
    Item garlic;

    ShoppingBasket basket ;
    List<Item> expectedSolution;

    @Before
    public void before() {
        apple = new Item("Apple", 0.25);
        banana = new Item("Banana",0.75);
        papaya = new Item("Papaya",0.50, new ThreeForTwo());
        garlic = new Item("Garlic",0.15);
        basket = new ShoppingBasket();
    }

    /**
     *
     */
    @Test
    public void testEmptyElement() {
        System.out.println("\nTest Empty Element");

        basket = new ShoppingBasket();
        System.out.println("\nResult:\n" + basket.toList());

        expectedSolution = new ArrayList<Item>();
        //System.out.println("Expected Solution " + expectedSolution.toString());
        assertThat(basket.getListItems(), equalTo(expectedSolution));
        assertEquals(basket.getTotalPrice(), 0.0, 0);
        System.out.println("\n*****************************************************************************");
    }


    /**
     *
     */
    @Test
    public void testOneElement() {
        System.out.println("\nTest One Element");

        basket = new ShoppingBasket();
        basket.addItem(new Item("Apple", 0.25));
        System.out.println("\nResult:\n" + basket.toList());

        expectedSolution = new ArrayList<Item>();
        apple.setQuantity(1);
        expectedSolution.add(apple);
        //System.out.println("Expected Solution " + expectedSolution.toString());
        assertThat(basket.getListItems(), equalTo(expectedSolution));
        assertEquals(basket.getTotalPrice(), 0.25, 0);
        System.out.println("\n*****************************************************************************");
    }


    /**
     *
     */
    @Test
    public void testFourItems() {
        System.out.println("\nTest Four Items");

        basket = new ShoppingBasket();

        basket.addItem(new Item("Apple", 0.25));
        basket.addItem(new Item("Banana",0.75));
        basket.addItem( new Item("Papaya",0.50, new ThreeForTwo()));
        basket.addItem( new Item("Papaya",0.50, new ThreeForTwo()));
        basket.addItem(new Item("Garlic", 0.15));
        basket.addItem(new Item("Garlic", 0.15));
        basket.addItem(new Item("Banana",0.75));

        System.out.println("\nResult:\n" + basket.toList());

        expectedSolution = new ArrayList<Item>();
        apple.setQuantity(1);
        banana.setQuantity(2);
        papaya.setQuantity(2);
        garlic.setQuantity(2);
        expectedSolution.add(apple);
        expectedSolution.add(papaya);
        expectedSolution.add(garlic);
        expectedSolution.add(banana);

        //System.out.println("Expected Solution " + expectedSolution.toString());
        assertThat(basket.getListItems(), equalTo(expectedSolution));
        assertEquals(basket.getTotalPrice(), 3.05, 0);
        System.out.println("\n*****************************************************************************");

    }

    /**
     *
     */
    @Test
    public void testThreeForTwo() {
        System.out.println("\nTest ThreeForTwo");

        basket = new ShoppingBasket();

        basket.addItem(new Item("Apple", 0.25));
        basket.addItem(new Item("Banana",0.75));
        basket.addItem( new Item("Papaya",0.50, new ThreeForTwo()));
        basket.addItem(new Item("Apple", 0.25));
        basket.addItem( new Item("Papaya",0.50, new ThreeForTwo()));
        basket.addItem( new Item("Papaya",0.50, new ThreeForTwo()));

        System.out.println("\nResult:\n" + basket.toList());

        expectedSolution = new ArrayList<Item>();
        apple.setQuantity(2);
        banana.setQuantity(1);
        papaya.setQuantity(3);
        expectedSolution.add(apple);
        expectedSolution.add(papaya);
        expectedSolution.add(banana);

        //System.out.println("Expected Solution " + expectedSolution.toString());
        assertThat(basket.getListItems(), equalTo(expectedSolution));
        assertEquals(basket.getTotalPrice(), 2.25, 0);
        System.out.println("\n*****************************************************************************");

    }
}