package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItem() {
        Item[] items = new Item[] { new Item("foo", 10, 21) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

    }

    @Test
//    void test() {
//        Item[] items = new Item[] {
//                new Item("Other", 10, 20), //
//                new Item("Aged Brie", 2, 0), //
//                new Item("Other Mee", 5, 7), //
//                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
//                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
//                new Item("ABCD", 3, 6) ,
//        new Item("ABCDE", 3, -2) };
//
//        GildedRose app = new GildedRose(items);
//
////        printItems(items);
//
//        app.updateQuality();
//
//        assertItem("Other", 9, 19, items[0]);
//        assertItem("Aged Brie", 1, 1, items[1]);
//        assertItem("Other Mee", 4, 6, items[2]);
//        assertItem("Sulfuras, Hand of Ragnaros", 0, 80, items[3]);
//        assertItem("Sulfuras, Hand of Ragnaros", -1, 80, items[4]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 14, 21, items[5]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 9, 50, items[6]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 4, 50, items[7]);
//        assertItem("ABCD", 2, 5, items[8]);
//        assertItem("ABCDE", 2, -2, items[9]);
//
//        app.updateQuality();
////        printItems(items);
//
//        assertItem("Other", 8, 18, items[0]);
//        assertItem("Aged Brie", 0, 2, items[1]);
//        assertItem("Other Mee", 3, 5, items[2]);
//        assertItem("Sulfuras, Hand of Ragnaros", 0, 80, items[3]);
//        assertItem("Sulfuras, Hand of Ragnaros", -1, 80, items[4]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 13, 22, items[5]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 8, 50, items[6]);
//        assertItem("Backstage passes to a TAFKAL80ETC concert", 3, 50, items[7]);
//        assertItem("ABCD", 1, 4, items[8]);
//        assertItem("ABCDE", 1, -2, items[9]);
//
//    }

    private static void assertItem(String abcd, int i, int i1, Item item) {
        assertEquals(abcd, item.name);
        assertEquals(i, item.sellIn);
        assertEquals(i1, item.quality);
    }

    static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }


}
