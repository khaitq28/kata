package gildedrose;

class BackstagePassUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.decreaseSellIn();
        if (item.isExpired()) {
            item.resetQuality();
            return;
        }
        item.increaseQuality();
        if (item.sellIn < 10) item.increaseQuality();
        if (item.sellIn < 5)  item.increaseQuality();
    }
}
