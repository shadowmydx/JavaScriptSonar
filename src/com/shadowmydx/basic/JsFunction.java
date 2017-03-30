package com.shadowmydx.basic;

import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.ast.AstNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class JsFunction extends JsObject {

    private AstNode codeTree;

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    private List<String> arguments = new ArrayList<String> ();

    public boolean isHaveThis() {
        return haveThis;
    }

    public void setHaveThis(boolean haveThis) {
        this.haveThis = haveThis;
    }

    private boolean haveThis = false;
    private Environment env;

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public AstNode getCodeTree() {

        return codeTree;
    }

    public void setCodeTree(AstNode codeTree) {
        this.codeTree = codeTree;
    }

    public JsFunction() {
        this.setType(FUNCTION);
    }

    @Override
    public String toString() {
        return "JsFunction";
    }
}
