package gildedrose;

import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.example.service.GildedRoseConjuredService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseConjuredServiceTest {

    private GildedRoseConjuredService gildedRoseConjuredService;

    @BeforeEach
    void setUp() {

        gildedRoseConjuredService = new GildedRoseConjuredService();
    }

    @ParameterizedTest
    @CsvSource({
            "15, 10, 8", // sellIn > 10, quality decrease of 2, from 10 to 8
            "10, 10, 8", // sellIn = 10, quality decrease of 2, from 10 to 8
            "5, 10, 8", // sellIn < 10, quality decrease of 2, from 10 to 8
            "0, 10, 6" // sellIn =< 0, quality decrease of 4, from 10 to 6
    })
    void testUpdateQuality(int sellIn, int initialQuality, int expectedQuality) {
        // Arrange
        Item item = new Item(ItemType.CONJURED.name(), sellIn, initialQuality);

        // Act
        gildedRoseConjuredService.updateQuality(item);

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
        gildedRoseConjuredService.updateSellin(item);

        // Assert
        assertEquals(expectedSellin, item.sellIn);
    }

}
