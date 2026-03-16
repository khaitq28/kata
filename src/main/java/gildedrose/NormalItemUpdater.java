package gildedrose;

class NormalItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.decreaseSellIn();
        item.decreaseQuality();
        if (item.isExpired()) {
            item.decreaseQuality();
        }
    }
}
