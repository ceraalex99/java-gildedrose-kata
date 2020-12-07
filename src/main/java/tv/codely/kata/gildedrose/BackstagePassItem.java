package tv.codely.kata.gildedrose;

public class BackstagePassItem extends UpdatableItem {
    private static final int SELL_IN_FOR_DOUBLE_INCREASE_QUALITY = 10;
    private static final int SELL_IN_FOR_TRIPLE_INCREASE_QUALITY = 5;
    private static final int SELL_IN_FOR_MIN_QUALITY             = 0;

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();

        if (sellIn < SELL_IN_FOR_DOUBLE_INCREASE_QUALITY) {
            increaseQuality();
        }
        if (sellIn < SELL_IN_FOR_TRIPLE_INCREASE_QUALITY) {
            increaseQuality();
        }


        if (sellIn < SELL_IN_FOR_MIN_QUALITY) {
            quality = MIN_QUALITY;
        }
    }
}
