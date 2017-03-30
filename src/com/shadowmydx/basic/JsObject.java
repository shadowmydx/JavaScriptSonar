package com.shadowmydx.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class JsObject extends BasicItem {
    private Map<String, BasicItem> container = new HashMap<String, BasicItem>();

    public JsObject() {
        this.setType(BasicItem.OBJECT);
    }

    public BasicItem get(String key) {
        return container.get(key);
    }

    public void remove(String key) {
        container.remove(key);
    }

    public void add(String key, BasicItem value) {
        container.put(key, value);
    }

    @Override
    public String toString() {
        return "JsObject";
    }
}
