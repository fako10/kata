package org.example.service;

import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;

public class GildedRoseAgedBrie extends DefaultGildedService {

    int qualityIncrease = 1;

    public int calculateQualityChange(Item item) {
        return item.sellIn <= 0 ? (2 * qualityIncrease) : qualityIncrease;
    }

    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality + calculateQualityChange(item);
        if(item.quality < 0) {
            item.quality = 0;
        }
        if(item.quality >  defaultMaxQuality) {
            item.quality = defaultMaxQuality;
        }
    }

}
