package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Block;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class BlockExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        Environment blockEnv = new Environment();
        blockEnv.setFatherEnv(env);
        Block block = (Block)node;
        for (Node statement : block) {
            Executor.executeNode((AstNode) statement, blockEnv);
        }
        return null;
    }
}
