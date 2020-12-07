package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseShould {
    private UpdatableItem[] arrayWith(UpdatableItem item) {
        return new UpdatableItem[]{item};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        UpdatableItem whateverUpdatableItem = new GenericItem("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverUpdatableItem));
        gildedRose.updateQuality();

        assertEquals(whateverUpdatableItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        UpdatableItem whateverUpdatableItem = new GenericItem("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverUpdatableItem));
        gildedRose.updateQuality();

        assertEquals(whateverUpdatableItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        UpdatableItem whateverUpdatableItem = new GenericItem("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverUpdatableItem));
        gildedRose.updateQuality();

        assertEquals(whateverUpdatableItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        UpdatableItem whateverUpdatableItem = new GenericItem("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverUpdatableItem));
        gildedRose.updateQuality();

        assertEquals(whateverUpdatableItem.quality, 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        UpdatableItem agedBrie = new AgedBrieItem("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        UpdatableItem agedBrie = new AgedBrieItem("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        UpdatableItem sulfuras = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        UpdatableItem backstagePasses = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        UpdatableItem backstagePasses = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        UpdatableItem backstagePasses = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        UpdatableItem backstagePasses = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 0);
    }
}
