package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.ParenthesizedExpression;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class ParenthesizedExecutor implements StatementExecutor {

    @Override
    public BasicItem execute(AstNode node, Environment env) {
        ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression) node;
        AstNode expr = parenthesizedExpression.getExpression();
        return Executor.executeNode(expr, env);
    }
}
