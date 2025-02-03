package org.example;

import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Item item = new Item("foo", 10, 20);
        Item item1 = new Item("Aged Brie", 10, 20);
        Item item2 = new Item("Sulfuras", 10, 20);
        Item item3 = new Item("Backstage passes", 10, 20);
        Item[] items = {item, item1, item2, item3};
        /*List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item1);
        items.add(item2);
        items.add(item3);*/

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQualities();

        System.out.println(item.toString());
        System.out.println(item1.toString());
        System.out.println(item2.toString());
        System.out.println(item3.toString());
        gildedRose.updateQualities();
        System.out.println(item.toString());
        System.out.println(item1.toString());
        System.out.println(item2.toString());
        System.out.println(item3.toString());
    }
}