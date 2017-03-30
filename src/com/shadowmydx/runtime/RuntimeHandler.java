package com.shadowmydx.runtime;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.basic.JsFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WULI5 on 3/18/2017.
 */
public class RuntimeHandler {

    private static Map<String, BasicItem> returnValues = new HashMap<String, BasicItem>();

    public static void rememberFunction(JsFunction function, BasicItem returnValue) {
        returnValues.put(function.hashCode() + "", returnValue);
    }

    public static BasicItem getFunctionReturnValue(JsFunction function) {
        return returnValues.get(function.hashCode() + "");
    }


}
