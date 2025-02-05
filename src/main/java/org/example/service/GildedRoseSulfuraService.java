package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseSulfuraService implements GildedRoseService {

    int sulfuraMaxQuality = 80;

    @Override
    public  void updateQuality(Item item) {
        item.quality = sulfuraMaxQuality;
    }
}
