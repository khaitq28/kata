package gildedrose;

class AgedBrieUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.decreaseSellIn();
        item.increaseQuality();
        if (item.isExpired()) {
            item.increaseQuality();
        }
    }
}
