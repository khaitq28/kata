package gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    private static final String AGE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;


    private boolean isAgedBrie() {
        return name.equals(AGE);
    }

    private boolean isBackstagePasses() {
        return name.equals(BACKSTAGE);
    }

    private boolean isSulfuras() {
        return name.equals(SULFURAS);
    }

    private boolean isSmallerThanMax() {
        return quality < MAX_QUALITY;
    }
    private boolean isGreaterThanMin() {
        return quality > MIN_QUALITY;
    }
    private void increaseQuality() {
        if (isSmallerThanMax()) {
            quality = quality + 1;
        }
    }
    private void decreaseQuality() {
        if (isGreaterThanMin()) {
            quality = quality - 1;
        }
    }
    private boolean isExpired() {
        return sellIn < 0;
    }
    private void decreaseSellIn() {
        sellIn = sellIn - 1;
    }
    private void resetQuality() {
        quality = 0;
    }

    private void updateQuality() {
        if (isAgedBrie()) {
            increaseQuality();
        } else if (isBackstagePasses()) {
            updateQualityForBackstage();
        } else if (!isSulfuras()) {
            decreaseQuality();
        }
    }

    private void updateQualityForBackstage() {
        if (!isSmallerThanMax()) {
            return;
        }
        increaseQuality();
        if (sellIn <= 10) {
            increaseQuality();
        }
        if (sellIn <= 5) {
            increaseQuality();
        }
    }

    private void handleExpiredSellIn() {
        if (isExpired()) {
            if (isAgedBrie()) {
                increaseQuality();
            } else if (isBackstagePasses()) {
                resetQuality();
            } else if (!isSulfuras()) {
                decreaseQuality();
            }
        }
    }

    public void updateItem() {
        updateQuality();
        if (!isSulfuras()) {
            decreaseSellIn();
        }
        handleExpiredSellIn();
    }

}
