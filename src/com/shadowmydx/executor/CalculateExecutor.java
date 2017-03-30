package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.basic.ErrorItem;
import com.shadowmydx.basic.ItemSet;
import com.shadowmydx.error.ErrorHandler;
import com.shadowmydx.error.JsError;
import com.shadowmydx.error.JsWarning;
import com.shadowmydx.error.TypeError;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.InfixExpression;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class CalculateExecutor implements StatementExecutor {
    @Override
    public BasicItem execute(AstNode node, Environment env) {
        InfixExpression infixExpression = (InfixExpression) node;
        AstNode left = infixExpression.getLeft();
        AstNode right = infixExpression.getRight();
        BasicItem leftValue = Executor.executeNode(left, env);
        BasicItem rightValue = Executor.executeNode(right, env);
        int operator = infixExpression.getOperator();
        if (leftValue instanceof ItemSet || rightValue instanceof ItemSet) {
            JsError warning = new JsWarning();
            warning.setNode(node);
            warning.setMsg("May have multiple type in this statement.");
            ErrorHandler.notifyWarning(warning);
            return new ErrorItem();
        }
        if (leftValue.toString().equals("Error") || rightValue.toString().equals("Error")) {
            return new ErrorItem();
        }
        if (Token.name(operator).equals("ADD")) {
            if ((!leftValue.toString().equals("JsString") && !leftValue.toString().equals("JsNumber")) || ((!rightValue.toString().equals("JsString") && !rightValue.toString().equals("JsNumber")))) {
                JsError error = new TypeError();
                error.setNode(node);
                error.setMsg("Only number or String can use this operator.");
                ErrorHandler.notifyError(error);
                return new ErrorItem();
            }
        } else {
            if (!leftValue.toString().equals("JsNumber")) {
                JsError error = new TypeError();
                error.setNode(node);
                error.setMsg("Only number can use this operator.");
                ErrorHandler.notifyError(error);
                return new ErrorItem();
            } else if (!rightValue.toString().equals("JsNumber")) {
                JsError error = new TypeError();
                error.setNode(node);
                error.setMsg("Only number can use this operator.");
                ErrorHandler.notifyError(error);
                return new ErrorItem();
            }
        }
        return leftValue;
    }
}

