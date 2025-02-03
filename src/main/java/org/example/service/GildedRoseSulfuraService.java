package org.example.service;

import org.example.gildedrose.Item;

public class GildedRoseSulfuraService extends DefaultGildedService {

    int sulfuraMaxQuality = 80;


    public  void updateQuality(Item item) {
        item.quality = sulfuraMaxQuality;
    }
}
