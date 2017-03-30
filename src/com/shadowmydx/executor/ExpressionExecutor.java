package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.ExpressionStatement;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class ExpressionExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        ExpressionStatement statement = (ExpressionStatement) node;
        AstNode expr = statement.getExpression();
        BasicItem item = Executor.executeNode(expr, env);
        return item;
    }
}
