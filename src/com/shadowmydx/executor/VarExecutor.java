package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;

import java.util.List;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class VarExecutor implements StatementExecutor {

    @Override
    public BasicItem execute(AstNode node, Environment env) {
        VariableDeclaration variableDeclaration = (VariableDeclaration) node;
        List<VariableInitializer> allVars = variableDeclaration.getVariables();
        for (VariableInitializer initializer : allVars) {
            Name target = (Name) initializer.getTarget();
            String varName = target.getIdentifier();
            AstNode source = initializer.getInitializer();
            BasicItem result = Executor.executeNode(source, env);
            if (result == null) {
                System.err.println("Assignment should have a value!! " + Token.name(source.getType()));
            } else {
                env.addMember(varName, result);
            }
        }
        return null;
    }
}
