package com.shadowmydx.error;

import org.mozilla.javascript.ast.AstNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/16/2017.
 */
public abstract class JsError {

    private AstNode node;

    public static final int TYPE_ERROR = 0, UNDEFINED_ERROR = 1, ARGS_MISMATCH = 2, WARNING = 3;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AstNode getNode() {

        return node;
    }

    public void setNode(AstNode node) {
        this.node = node;
    }
}
