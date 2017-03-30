package com.shadowmydx.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class JsArray extends JsObject {
    private List<BasicItem> container = new ArrayList<BasicItem>();
    public JsArray() {
        this.setType(ARRAY);

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
        return "JsArray";
    }
}
