package com.shadowmydx.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public abstract class BasicItem {

    public static final int BOOLEAN = 0, NUMBER = 1, STRING = 2, ARRAY = 3, OBJECT = 4, FUNCTION = 5, REGEX = 6, ERROR = 7, ITEM_SET = 8;

    private static List<String> typeString = new ArrayList<String>();

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    static {

        typeString.add("BOOLEAN");
        typeString.add("NUMBER");
        typeString.add("STRING");
        typeString.add("ARRAY");
        typeString.add("OBJECT");
        typeString.add("FUNCTION");
        typeString.add("REGEX");
        typeString.add("EEROR");
        typeString.add("ITEM_SET");
    }

    public static String getType(int num) {
        return typeString.get(num);
    }

    public static BasicItem getItemByString(String key) {
        switch (key) {
            case "NUMBER" : return new JsNumber();
            case "STRING" : return new JsString();
            case "FUNCTION" : return new JsFunction();
            case "BOOLEAN" : return new JsBoolean();
            case "OBJECTLIT" : return new JsObject();
            default : return null;
        }
    }
}
