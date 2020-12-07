package tv.codely.kata.gildedrose;

public class GenericItem extends UpdatableItem {
    private static final int SELL_IN_THAT_DECREASES_QUALITY = 0;

    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        if (sellIn < SELL_IN_THAT_DECREASES_QUALITY) {
            decreaseQuality();
        }
    }
}
