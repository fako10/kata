package org.example.service;

import org.example.gildedrose.Item;

public interface GildedRoseService {

     int DEFAULT_QUALITY_DECREASE = -1;
     int DEFAULT_MAX_QUALITY = 50;
     int DEFAULT_MIN_QUALITY = 0;

     default int calculateQualityChange(Item item) {
          return item.sellIn <= 0 ? (2 * DEFAULT_QUALITY_DECREASE) : DEFAULT_QUALITY_DECREASE;
     }

     default void reajusteQuality(Item item) {
          item.quality = Math.clamp(item.quality, DEFAULT_MIN_QUALITY, DEFAULT_MAX_QUALITY);

     }

     default void updateSellin(Item item) {
          item.sellIn--;
     }

     default void updateQuality(Item item) {
          item.quality = item.quality + calculateQualityChange(item);
          reajusteQuality(item);
     }


     default void update(Item item) {
          updateSellin(item);
          updateQuality(item);
     }

}
