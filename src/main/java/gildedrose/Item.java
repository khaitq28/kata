package gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void increaseQuality() {
        if (quality < MAX_QUALITY) quality++;
    }

    void decreaseQuality() {
        if (quality > MIN_QUALITY) quality--;
    }

    void decreaseSellIn() {
        sellIn--;
    }

    void resetQuality() {
        quality = 0;
    }

    boolean isExpired() {
        return sellIn < 0;
    }
}
