package org.example.factory;

import org.example.service.GildedRoseService;

public interface GildedRoseFactory {

    GildedRoseService createGildedRose(String filename );

}
