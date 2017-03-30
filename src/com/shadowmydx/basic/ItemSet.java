package com.shadowmydx.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 * if a function can return multiple type.
 */
public class ItemSet extends BasicItem {
    private List<BasicItem> container = new ArrayList<BasicItem>();
    public ItemSet() {
        this.setType(ITEM_SET);

    }

    public BasicItem getArrayItem(int index) {
        return container.get(index);
    }

    public void addArrayItem(int index, BasicItem item) {
        container.set(index, item);
    }

    public void removeArrayItem(int index) {
        container.remove(index);
    }

    @Override
    public String toString() {
        return "ITEM_SET";
    }
}
