package gildedrose;

import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.example.service.GildedRoseAgedBrieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseAgedBrieServiceTest {

    private GildedRoseAgedBrieService gildedRoseAgedBrieService;

    @BeforeEach
    void setUp() {

        gildedRoseAgedBrieService = new GildedRoseAgedBrieService();

    }

    @ParameterizedTest
    @CsvSource({
            "15, 1",    // sellIn > 10, quality increase of 1
            "10, 1",    // sellIn <= 10 et > 5, quality increase of 1
            "5, 1",     // sellIn <= 5,quality increase of 1
            "0, 1"      // sellIn <= 0, quality increase of 1
    })
    void testCalculateQualityChange(int sellIn, int expectedQualityChange) {

        Item item = new Item(ItemType.AGED_BRIE.name(), sellIn, 10); // 10 est une qualité initiale arbitraire

        // Act
        int actualQualityChange = gildedRoseAgedBrieService.calculateQualityChange(item);

        // Assert
        assertEquals(expectedQualityChange, actualQualityChange);

    }

    @ParameterizedTest
    @CsvSource({
            "15, 10, 11",  // sellIn > 10, quality increase of 1, for 10 to 11
            "10, 10, 11", // sellIn = 10, quality increase of 1, for 10 to 11
            "10, 50, 50", // sellIn = 10, quality  can't be more than 50
            "0, 10, 11" // sellIn = 0, quality increase of 1, for 10 to 11
    })
    void testUpdateQuality(int sellIn, int initialQuality, int expectedQuality) {
        // Arrange
        Item item = new Item(ItemType.AGED_BRIE.name(), sellIn, initialQuality);

        // Act
        gildedRoseAgedBrieService.updateQuality(item);

        // Assert
        assertEquals(expectedQuality, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
            "15, 14", // sellin decrease of 1
    })
    void testSellin(int sellIn, int expectedSellin) {
        // Arrange
        Item item = new Item(ItemType.SULFURAS.name(), sellIn, 40);

        // Act
        gildedRoseAgedBrieService.updateSellin(item);

        // Assert
        assertEquals(expectedSellin, item.sellIn);
    }

}
