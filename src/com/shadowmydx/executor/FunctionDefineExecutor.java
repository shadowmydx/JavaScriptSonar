package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.basic.JsFunction;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class FunctionDefineExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        FunctionNode function = (FunctionNode) node;
        Block codeBody = (Block) function.getBody();
        JsFunction jsFunction = new JsFunction();
        List<AstNode> paramsNode = function.getParams();
        List<String> params = new ArrayList<String> ();
        for (AstNode singleParam : paramsNode) {
            params.add(((Name)singleParam).getIdentifier());
        }
        jsFunction.setArguments(params);
        jsFunction.setCodeTree(codeBody);
        jsFunction.setEnv(env);
        if (function.getFunctionName() != null) {
            env.addMember(function.getFunctionName().getIdentifier(), jsFunction);
        }
        return jsFunction;
    }
}
