package tv.codely.kata.gildedrose;

class GildedRose {
    private static final String AGED_BRIE                                          = "Aged Brie";
    private static final String BACKSTAGE_PASSES                                   = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS                                           = "Sulfuras, Hand of Ragnaros";

    UpdatableItem[] items;

    public GildedRose(UpdatableItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (UpdatableItem item : items) {
            if (!item.name.equals(SULFURAS))
                item.decreaseSellIn();
            item.updateQuality();
        }
    }
}
