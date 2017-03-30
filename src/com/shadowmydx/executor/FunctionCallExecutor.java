package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.basic.ErrorItem;
import com.shadowmydx.basic.JsFunction;
import com.shadowmydx.error.ArgsError;
import com.shadowmydx.error.ErrorHandler;
import com.shadowmydx.error.JsError;
import com.shadowmydx.runtime.Environment;
import com.shadowmydx.runtime.RuntimeHandler;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.FunctionCall;

import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class FunctionCallExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        FunctionCall caller = (FunctionCall) node;
        JsFunction targetFunction = (JsFunction) Executor.executeNode(caller.getTarget(), env);
        Environment localEnv = new Environment();
        List<String> arguments = targetFunction.getArguments();
        List<AstNode> values = caller.getArguments();
        if (values.size() > arguments.size()) {
            JsError error = new ArgsError();
            error.setNode(node);
            error.setMsg("Function can only accept " + arguments.size() + " arguments while is given " + values.size() + " arguments.");
            ErrorHandler.notifyError(error);
            return new ErrorItem();
        }
        for (int i = 0; i < values.size(); i ++) {
            BasicItem result = Executor.executeNode(values.get(i), null); // won't need env here.
            localEnv.addMember(arguments.get(i), result);
        }
        localEnv.setFatherEnv(targetFunction.getEnv());
        Environment.callFunction(targetFunction, localEnv.copy());
        BasicItem returnValue = Executor.executeNode(targetFunction.getCodeTree(), localEnv);
        Environment.returnFunction();
        return returnValue;
    }
}
