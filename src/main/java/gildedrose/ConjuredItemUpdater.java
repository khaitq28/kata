package gildedrose;

class ConjuredItemUpdater implements ItemUpdater {

    // Conjured items degrade in quality twice as fast as normal items
    @Override
    public void update(Item item) {
        item.decreaseSellIn();
        item.decreaseQuality();
        item.decreaseQuality();
        if (item.isExpired()) {
            item.decreaseQuality();
            item.decreaseQuality();
        }
    }
}
