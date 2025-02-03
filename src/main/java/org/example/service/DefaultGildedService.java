package org.example.service;

import org.example.gildedrose.Item;

public class DefaultGildedService implements GildedRoseService {

    int defaultQualityDecrease = -1;
    int defaultMaxQuality = 50;

     int calculateQualityChange(Item item) {
        return item.sellIn <= 0 ? (2 * defaultQualityDecrease) : defaultQualityDecrease;
    }

     void reajusteQuality(Item item) {
        if(item.quality < 0) {
            item.quality = 0;
        }
        if(item.quality > defaultMaxQuality) {
            item.quality = defaultMaxQuality;
        }
    }

    @Override
    public void updateSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    public  void updateQuality(Item item) {
        item.quality = item.quality + calculateQualityChange(item);
        reajusteQuality(item);
    }

    @Override
    public void update(Item item) {
        updateSellin(item);
        updateQuality(item);
    }


}
