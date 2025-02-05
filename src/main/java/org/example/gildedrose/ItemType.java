package org.example.gildedrose;

public enum  ItemType {

    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras"),
    BACKSTAGE("Backstage passes"),
    CONJURED("Conjured");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

}
