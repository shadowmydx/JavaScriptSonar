package com.shadowmydx.executor;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.error.ErrorHandler;
import com.shadowmydx.runtime.Environment;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class Executor {
    private static Map <String, StatementExecutor> executors = new HashMap<String, StatementExecutor>();
    private static StatementExecutor terminate = new TerminateExecutor();
    private static CalculateExecutor calculate = new CalculateExecutor();
    private static ExpressionExecutor expression = new ExpressionExecutor();

    static {
        executors.put("VAR", new VarExecutor());
        executors.put("SCRIPT", new ScriptExecutor());
        executors.put("NAME", new NameExecutor());
        executors.put("FUNCTION", new FunctionDefineExecutor());
        executors.put("CALL", new FunctionCallExecutor());
        executors.put("BLOCK", new BlockExecutor());
        executors.put("EXPR_RESULT", expression);
        executors.put("EXPR_VOID", expression);
        executors.put("ASSIGN", new AssignExecutor());
        executors.put("SUB", calculate);
        executors.put("ADD", calculate);
        executors.put("MUL", calculate);
        executors.put("DIV", calculate);
        executors.put("LP", new ParenthesizedExecutor());
        executors.put("NUMBER", terminate);
        executors.put("STRING", terminate);
        executors.put("OBJECTLIT", terminate);
    }

    public static String getType(AstNode node) {
        return Token.name(node.getType());
    }

    public static BasicItem executeNode(AstNode node, Environment env) {
        if (node == null) {
            return null;
        }
        String nodeType = Token.name(node.getType());
        StatementExecutor executor = executors.get(nodeType);
        if (executor == null) {
            System.out.println("Can't handle node " + nodeType + " for now..");
            return null;
        } else {
            return executor.execute(node, env);
        }
    }

    public static void main(String[] args) {
        String code = "(function (e,f,g) {var a = 1, b = 2, c = 3;\nvar d = 'abcd';\na = b * 3;\nd = a+(d+c*2)/3 - 3* (1 + 2);\nreturn a,b,c,d+'abc';})(1,2,3); var a = 1, b = 2, c = 3;\nvar d = 'abcd';\na = b * 3;\nd = a+(d+c*2)/3 - 3* (1 + 2);\nvar e = 1;var f = {}; var g = new a(); var g = 'sdfsdf'; var g = {a:1,b:'sdfa', c:{}};";
        //code = "function a(b) {b = b + 1; a = a + 2; a +1;return a + 1;} var b = 2;b++;while(b!=1){b--;}c.z;new a();'sdfsdfsd';a+(b+c*2)/3 - 3* (1 + 2);'abc' + 'bcd';";
        //code = "var a = {};a[0][1].z = 1;";
        Parser parser = new Parser();
        AstNode root = parser.parse(code, null, 1);
        Environment environment = new Environment();
        executeNode(root, environment);
        ErrorHandler.report();
        System.out.println("debug");
    }

}
