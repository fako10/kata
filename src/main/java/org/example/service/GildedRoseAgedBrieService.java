package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseAgedBrieService implements GildedRoseService {

    int qualityIncrease = 1;

    @Override
    public int calculateQualityChange(Item item) {
        return qualityIncrease;
    }

    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality + calculateQualityChange(item);
        reajusteQuality(item);
    }

}
