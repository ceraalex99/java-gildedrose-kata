package tv.codely.kata.gildedrose;

public abstract class UpdatableItem extends Item {
    protected final int MAX_QUALITY = 50;
    protected final int MIN_QUALITY = 0;

    public UpdatableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void update();

    protected void increaseQuality(){
        if(quality < MAX_QUALITY)
            quality++;
    }

    protected void decreaseQuality(){
        if(quality > MIN_QUALITY)
            quality--;
    }

    protected void decreaseSellIn(){
        sellIn--;
    }
}
