package gildedrose;

class ItemUpdaterFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    static ItemUpdater getUpdater(Item item) {
        return switch (item.name) {
            case AGED_BRIE  -> new AgedBrieUpdater();
            case BACKSTAGE  -> new BackstagePassUpdater();
            case SULFURAS   -> new SulfurasUpdater();
            case CONJURED   -> new ConjuredItemUpdater();
            default         -> new NormalItemUpdater();
        };
    }
}
