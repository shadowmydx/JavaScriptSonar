package com.shadowmydx.error;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class ArgsError extends JsError {
    public ArgsError() {
        this.setType(ARGS_MISMATCH);
    }
}
