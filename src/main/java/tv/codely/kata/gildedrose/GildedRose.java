package tv.codely.kata.gildedrose;

import java.util.List;

class GildedRose {

    public void updateQuality(List<UpdatableItem> items) {
        items.forEach(UpdatableItem::update);
    }
}
