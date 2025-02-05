package org.example.factory;

import org.example.gildedrose.ItemType;
import org.example.service.*;

import java.util.HashMap;
import java.util.Map;

public class GildedRoseFactory {

    private static final Map<String, GildedRoseService> serviceMap = new HashMap<>();

    static {
        serviceMap.put(ItemType.AGED_BRIE.name(), new GildedRoseAgedBrieService());
        serviceMap.put(ItemType.SULFURAS.name(), new GildedRoseSulfuraService());
        serviceMap.put(ItemType.BACKSTAGE.name(), new GildedRoseBackStageService());
        serviceMap.put(ItemType.CONJURED.name(), new GildedRoseConjuredService());
    }

    public GildedRoseService createGildedRose(String filename) {

        return serviceMap.getOrDefault(filename, new DefaultGildedService());
    }

}
