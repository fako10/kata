package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseConjuredService implements GildedRoseService {

    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality + (2 * calculateQualityChange(item));
        reajusteQuality(item);
    }
}
