package gildedrose;

import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.example.service.GildedRoseSulfuraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseSulfuraServiceTest {

    private GildedRoseSulfuraService gildedRoseSulfuraService;

    @BeforeEach
    void setUp() {

        gildedRoseSulfuraService = new GildedRoseSulfuraService();

    }

    @ParameterizedTest
    @CsvSource({
            "15, 10, 80", // quality is 80 and can't change
            "10, 10, 80", // quality is 80 and can't change
            "5, 10, 80", // quality is 80 and can't change
            "0, 10, 80" // quality is 80 and can't change
    })
    void testUpdateQuality(int sellIn, int initialQuality, int expectedQuality) {
        // Arrange
        Item item = new Item(ItemType.SULFURAS.name(), sellIn, initialQuality);

        // Act
        gildedRoseSulfuraService.updateQuality(item);

        // Assert
        assertEquals(expectedQuality, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 1000", // sellin in sulfuras don't have sellin date, we use 1000 as default value
    })
    void testSellin(int sellIn, int expectedSellin) {
        // Arrange
        Item item = new Item(ItemType.SULFURAS.name(), sellIn, 40);

        // Act
        gildedRoseSulfuraService.updateSellin(item);

        // Assert
        assertEquals(expectedSellin, item.sellIn);
    }

}
