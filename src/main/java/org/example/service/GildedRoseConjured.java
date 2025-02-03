package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseConjured extends  DefaultGildedService {

    public void updateQuality(Item item) {
        item.quality = item.quality + (2 * calculateQualityChange(item));
        reajusteQuality(item);
    }
}
