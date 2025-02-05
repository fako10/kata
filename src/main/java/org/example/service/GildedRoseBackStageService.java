package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseBackStageService implements  GildedRoseService {

    @Override
    public int calculateQualityChange(Item item) {

        if (item.sellIn <= 0) {
            return 0;
        } else if (item.sellIn <= 5) {
            return 3;
        } else if (item.sellIn <= 10) {
            return 2;
        }
        return 1;
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
