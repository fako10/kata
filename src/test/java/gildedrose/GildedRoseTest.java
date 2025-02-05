package gildedrose;

import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item item = new Item("foo", 10, 20);
        Item item1 = new Item(ItemType.AGED_BRIE.name(), 10, 20);
        Item item2 = new Item(ItemType.SULFURAS.name(), 10, 20);
        Item item3 = new Item(ItemType.BACKSTAGE.name(), 7, 20);
        Item item4 = new Item(ItemType.CONJURED.name(), 10, 20);
        Item[] items = {item, item1, item2, item3, item4};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(21, app.items[1].quality);
        assertEquals(80, app.items[2].quality);
        assertEquals(22, app.items[3].quality);
        assertEquals(18, app.items[4].quality);
        assertEquals(9, app.items[0].sellIn);
    }
}
