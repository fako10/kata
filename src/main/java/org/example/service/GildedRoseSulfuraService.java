package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseSulfuraService implements GildedRoseService {

    int sulfuraMaxQuality = 80;
    static int sulfurasInchangeableSellin = 1000;

    @Override
    public void updateSellin(Item item) {
        item.sellIn = sulfurasInchangeableSellin;
    }

    @Override
    public  void updateQuality(Item item) {
        item.quality = sulfuraMaxQuality;
    }
}
