package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Name;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class AssignExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        Assignment assignment = (Assignment) node;
        Name identifier = (Name)assignment.getLeft();
        BasicItem right = Executor.executeNode(assignment.getRight(), env);
        env.addMember(identifier.getIdentifier(), right);
        return null;
    }
}
