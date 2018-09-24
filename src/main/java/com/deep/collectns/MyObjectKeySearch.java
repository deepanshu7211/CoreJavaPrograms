package com.deep.collectns;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 14/03/16.
 */
public class MyObjectKeySearch {
    public static void main(String[] args) {
        HashMap<Price, String> hm = new HashMap<Price, String>();
        hm.put(new Price("Banana", 20), "Banana");
        hm.put(new Price("Apple", 40), "Apple");
        hm.put(new Price("Orange", 30), "Orange");
        printMap(hm);
        Price key = new Price("Banana", 20);
        System.out.println("Does key available? " + hm.containsKey(key));
    }

    public static void printMap(HashMap<Price, String> map) {

        Set<Price> keys = map.keySet();
        for (Price p : keys) {
            System.out.println(p + "==>" + map.get(p));
        }
    }

}


class Price {
    private String item;
    private int price;

    public Price(String item, int price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println("  equals ..... ");
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Price)) return false;

        Price price1 = (Price) o;

        return (price1.item.equals(item) && price1.price == price);

    }

    @Override
    public int hashCode() {
//        System.out.println("  hashCode ..... ");

        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "Price [item=" + item + ", price=" + price + "]";
	}
    
    
}