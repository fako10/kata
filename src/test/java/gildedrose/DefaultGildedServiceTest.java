package gildedrose;

import org.example.gildedrose.Item;
import org.example.gildedrose.ItemType;
import org.example.service.DefaultGildedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultGildedServiceTest {

    private DefaultGildedService defaultGildedService;

    @BeforeEach
    void setUp() {

        defaultGildedService = new DefaultGildedService();
    }

    @ParameterizedTest
    @CsvSource({
            "15, -1", // sellIn > 10, quality decreasa de 1
            "10, -1", // sellIn = 10, quality decreasa de 1
            "0, -2" // sellIn =<  0, quality decreasa de 2
    })
    void testCalculateQualityChange(int sellIn, int expectedQualityChange) {

        Item item = new Item("Cars", sellIn, 10); // 10 est une qualité initiale arbitraire

        // Act
        int actualQualityChange = defaultGildedService.calculateQualityChange(item);

        // Assert
        assertEquals(expectedQualityChange, actualQualityChange);

    }

    @ParameterizedTest
    @CsvSource({
            "15, 10, 9", // sellIn > 10, quality decreasa de 1, for 10 to 9
            "0, 0, 0", //  quality = 0 , but quality can't be negative
            "5, 10, 9", // sellIn < 5, quality decreasa de 1, for 10 to 9
            "0, 10, 8" // sellIn < 0, quality decreasa de 2, for 10 to 8
    })
    void testUpdateQuality(int sellIn, int initialQuality, int expectedQuality) {
        // Arrange
        Item item = new Item("Cars", sellIn, initialQuality);

        // Act
        defaultGildedService.updateQuality(item);

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
        defaultGildedService.updateSellin(item);

        // Assert
        assertEquals(expectedSellin, item.sellIn);
    }

}
