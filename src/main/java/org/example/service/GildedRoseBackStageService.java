package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseBackStageService implements  GildedRoseService {

    @Override
    public int calculateQualityChange(Item item) {

        int qualityIncrease = 1;

        if(item.sellIn <= 10 && item.sellIn > 5) {
            qualityIncrease = 2;
        } else if(item.sellIn <= 5 && item.sellIn > 0) {
            qualityIncrease = 3;
        } else if(item.sellIn <= 0) {
            qualityIncrease = 0;
        }
        return qualityIncrease;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            item.quality += calculateQualityChange(item);
            reajusteQuality(item);
        }
    }
}
