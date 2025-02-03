package org.example.factory;

import org.example.gildedrose.GildedRose;
import org.example.service.*;

public class GildedRoseFactoryImpl implements GildedRoseFactory {


    @Override
    public GildedRoseService createGildedRose(String filename) {

        if (filename.equals("Aged Brie")) {
            return new GildedRoseAgedBrie();
        } else if (filename.equals("Sulfuras")) {
            return new GildedRoseSulfuraService();
        } else if (filename.equals("Backstage passes")) {
            return new GildedRoseBackStage();
        } else if (filename.equals("Conjured")) {
            return new GildedRoseConjured();
        }
        return new DefaultGildedService();
    }
}
