package tv.codely.kata.gildedrose;

class GildedRose {
    private static final String AGED_BRIE        = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS         = "Sulfuras, Hand of Ragnaros";
    private static final int    MAX_QUALITY      = 50;
    private static final int MIN_QUALITY = 0;
    private static final int GENERIC_SELL_IN_THAT_DECREASES_QUALITY             = 0;
    private static final int BACKSTAGE_PASS_SELL_IN_FOR_DOUBLE_INCREASE_QUALITY = 11;
    private static final int BACKSTAGE_PASS_SELL_IN_FOR_TRIPLE_INCREASE_QUALITY = 6;
    private static final int BACKSTAGE_PASS_SELL_IN_FOR_MIN_QUALITY = 0;
    private static final int AGED_BRIE_SELL_IN_FOR_DOUBLE_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    decreaseSellIn(item);
                    agedBrieUpdateQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    decreaseSellIn(item);
                    backstagePassUpdateQuality(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    decreaseSellIn(item);
                    genericUpdateQuality(item);
                    break;
            }
        }
    }

    private void genericUpdateQuality(Item item) {


        if (item.sellIn < GENERIC_SELL_IN_THAT_DECREASES_QUALITY) {
            if (item.quality > MIN_QUALITY) {
                decreaseQuality(item);
            }
        }
    }

    private void backstagePassUpdateQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn < BACKSTAGE_PASS_SELL_IN_FOR_DOUBLE_INCREASE_QUALITY) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
        if (item.sellIn < BACKSTAGE_PASS_SELL_IN_FOR_TRIPLE_INCREASE_QUALITY) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }


        if (item.sellIn < BACKSTAGE_PASS_SELL_IN_FOR_MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
    }

    private void agedBrieUpdateQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
        }


        if (item.sellIn < AGED_BRIE_SELL_IN_FOR_DOUBLE_QUALITY) {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        if(item.quality > MIN_QUALITY)
            item.quality--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY)
            item.quality++;
    }
}
