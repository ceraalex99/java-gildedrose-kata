package tv.codely.kata.gildedrose;

class GildedRose {
    private static final String AGED_BRIE        = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS         = "Sulfuras, Hand of Ragnaros";
    private static final int    MAX_QUALITY      = 50;
    private static final int    MIN_QUALITY      = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    agedBrieUpdateQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    backstagePassUpdateQuality(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    genericUpdateQuality(item);
                    break;
            }
        }
    }

    private void genericUpdateQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            if (item.quality > MIN_QUALITY) {
                decreaseQuality(item);
            }
        }
    }

    private void backstagePassUpdateQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn < 11) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;
        }
    }

    private void agedBrieUpdateQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
        }
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }
}
