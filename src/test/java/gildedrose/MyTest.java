package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    /**
     * 1. normal
     * 2. age
     * 3. backstage
     * 4. sulfuras
     *
     * quality bound: 0, 50
     * SellIn bound: 0
     */

    private final String NORMAL = "foo";
    private final String AGE = "Aged Brie";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void normalItem() {

        Item[] items = new Item[] { new Item(NORMAL, 10, 21),
                                    new Item(NORMAL, 10, 0),
                                    new Item(NORMAL, 0, 15),
                                    new Item(NORMAL, 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(NORMAL, 9 , 20 , app.items[0]);
        assertItem(NORMAL, 9 , 0 , app.items[1]);
        assertItem(NORMAL, -1 , 13 , app.items[2]);
        assertItem(NORMAL, -1 , 0 , app.items[3]);

    }

    @Test
    void ageItem() {

        Item[] items = new Item[] { new Item(AGE, 10, 21),
                                    new Item(AGE, 10, 50),
                                    new Item(AGE, 0, 15),
                                    new Item(AGE, 0, 50)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(AGE, 9 , 22 , app.items[0]);
        assertItem(AGE, 9 , 50 , app.items[1]);
        assertItem(AGE, -1 , 17 , app.items[2]);
        assertItem(AGE, -1 , 50, app.items[3]);

    }

    @Test
    void backItem() {

        Item[] items = new Item[] {
                new Item(BACKSTAGE, 15, 21),
                new Item(BACKSTAGE, 10, 21),
                new Item(BACKSTAGE, 4, 21),
                new Item(BACKSTAGE, 0, 21),
                new Item(BACKSTAGE, 10, 50),
                new Item(BACKSTAGE, 0, 50),

                new Item(BACKSTAGE, 4, 49)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertItem(BACKSTAGE, 14 , 22 , app.items[0]);
        assertItem(BACKSTAGE, 9 , 23 , app.items[1]);
        assertItem(BACKSTAGE, 3 , 24 , app.items[2]);
        assertItem(BACKSTAGE, -1 , 0 , app.items[3]);
        assertItem(BACKSTAGE, 9 , 50, app.items[4]);
        assertItem(BACKSTAGE, -1 , 0, app.items[5]);
        assertItem(BACKSTAGE, 3 , 50, app.items[6]);


    }


    @Test
    void sulfrasItem() {

        Item[] items = new Item[] { new Item(SULFURAS, 10, 20),
                                    new Item(SULFURAS, 0, 20),
                                    new Item(SULFURAS, -1, 50)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(SULFURAS, 10 , 20 , app.items[0]);
        assertItem(SULFURAS, 0 , 20 , app.items[1]);
        assertItem(SULFURAS, -1 , 50 , app.items[2]);

    }

    private void assertItem(String name, int sellIn, int quality, Item item) {
        assertEquals(name, item.name);
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }
}
