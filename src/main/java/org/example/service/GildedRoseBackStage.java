package org.example.service;

import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;

public class GildedRoseBackStage extends  DefaultGildedService {

    public int calculateQualityChange(Item item) {

        int qualityIncrease = 1;

        if(item.sellIn <= 10 && item.sellIn > 5) {
            qualityIncrease = 2;
        } else if(item.sellIn <= 5) {
            qualityIncrease = 3;
        }
        return qualityIncrease;
    }

    public void updateQuality(Item item) {

        item.quality = item.quality + calculateQualityChange(item);
        reajusteQuality(item);

    }
}
