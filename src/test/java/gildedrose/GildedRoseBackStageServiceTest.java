package gildedrose;

import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.example.service.GildedRoseBackStageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseBackStageServiceTest {

    private GildedRoseBackStageService gildedRoseBackStage;

    @BeforeEach
    void setUp() {
        gildedRoseBackStage = new GildedRoseBackStageService();
    }

    @ParameterizedTest
    @CsvSource({
            "15, 1",    // sellIn > 10, quality increase of 1
            "10, 2",    // sellIn <= 10 et > 5, quality increase of 2
            "5, 3",     // sellIn <= 5, quality increase of 3
            "0, 0"      // sellIn <= 0, quality is set to 0
    })
    void testCalculateQualityChange(int sellIn, int expectedQualityChange) {

        Item item = new Item(ItemType.BACKSTAGE.name(), sellIn, 10); // 10 est une qualité initiale arbitraire

        // Act
        int actualQualityChange = gildedRoseBackStage.calculateQualityChange(item);

        // Assert
        assertEquals(expectedQualityChange, actualQualityChange);

    }

    @ParameterizedTest
    @CsvSource({
            "15, 10, 11",  // sellIn > 10, quality increase of 1, from 10 to 11
            "10, 10, 12",  // sellIn <= 10 et > 5, quality increase de 2, from 10 to 12
            "5, 10, 13",   // sellIn <= 5, quality increase de 3, from 10 to 13
            "0, 10, 0"    // sellIn <= 0, quality set to 0
    })
    void testUpdateQuality(int sellIn, int initialQuality, int expectedQuality) {
        // Arrange
        Item item = new Item(ItemType.BACKSTAGE.name(), sellIn, initialQuality);

        // Act
        gildedRoseBackStage.updateQuality(item);

        // Assert
        assertEquals(expectedQuality, item.quality);
    }
}
