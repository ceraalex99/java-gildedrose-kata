package tv.codely.kata.gildedrose;

public class AgedBrieItem extends UpdatableItem {
    private final int SELL_IN_FOR_DOUBLE_QUALITY = 0;

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();


        if (sellIn < SELL_IN_FOR_DOUBLE_QUALITY) {
            increaseQuality();
        }
    }
}
