package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class TerminateExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        return BasicItem.getItemByString(Executor.getType(node));
    }
}
