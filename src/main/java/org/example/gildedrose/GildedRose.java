package org.example.gildedrose;

import org.example.factory.GildedRoseFactory;
import org.example.service.*;

import java.util.Arrays;
import java.util.Optional;

public class GildedRose {

    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update(Item item) {

        GildedRoseFactory factory = new GildedRoseFactory();
        GildedRoseService gildedRoseService = factory.createGildedRose(item.name);
        gildedRoseService.update(item);

    }

    public void updateQuality() {
        Optional.ofNullable(items).ifPresent(itemsArray -> Arrays.stream(itemsArray).forEach(this::update));
    }
}
