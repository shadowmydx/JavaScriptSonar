package com.shadowmydx.basic;

/**
 * Created by WULI5 on 3/17/2017.
 * For ErrorHandler to detect Error.
 */
public class ErrorItem extends BasicItem {

    public ErrorItem() {
        this.setType(ERROR);
    }

    @Override
    public String toString() {
        return "Error";
    }

}
