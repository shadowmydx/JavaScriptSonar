package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class ScriptExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        if (node == null) {
            return null;
        }
        AstNode start = (AstNode) node.getFirstChild();
        while (start != null) {
            Executor.executeNode(start, env);
            execute((AstNode) start.getFirstChild(), env);
            start = (AstNode) start.getNext();
        }
        return null;
    }
}
