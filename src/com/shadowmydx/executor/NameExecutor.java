package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Name;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class NameExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        String identifier = ((Name)node).getIdentifier();
        BasicItem item = env.getMember(identifier);
        return item;
    }
}
