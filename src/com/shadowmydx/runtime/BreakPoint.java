package com.shadowmydx.runtime;

import org.mozilla.javascript.ast.AstNode;

/**
 * Created by WULI5 on 3/18/2017.
 */
public class BreakPoint {

    private AstNode currentNode;
    private Environment currentEnv;

    public Environment getCurrentEnv() {
        return currentEnv;
    }

    public void setCurrentEnv(Environment currentEnv) {
        this.currentEnv = currentEnv;
    }

    public AstNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(AstNode currentNode) {
        this.currentNode = currentNode;
    }
}
