package com.shadowmydx.text;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.FunctionNode;

public class ASTest {

	public ASTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
			Parser parser = new Parser();
			String code = "function a(b) {b = b + 1; a = a + 2; a +1;return a + 1;} var b = 2;b++;while(b!=1){b--;}c.z;new a();'sdfsdfsd';a+(b+c*2)/3 - 3* (1 + 2);'abc' + 'bcd';";
			String code1 = "var a = 1, b = 2, c = 3;var d = a+(b+c*2)/3 - 3* (1 + 2);";
		    AstRoot root = parser.parse(code1, null, 1);
			System.out.println("hello");
			Node first = root.getFirstChild();
			showTree(first);
			//System.out.println(first.toString());
	}
	
	public static void showTree(Node first) {
		Node start = first;
		while (start != null) {
			if (start.getType() == Token.FUNCTION) {
				FunctionNode functionNode = (FunctionNode) start;
				showTree(functionNode.getBody());
			} else if (start.getType() == Token.EXPR_VOID || start.getType() == Token.EXPR_RESULT) {
				ExpressionStatement expressionStatement = (ExpressionStatement) start;
				System.out.println(expressionStatement.getExpression());
				AstNode node = expressionStatement.getExpression();
				System.out.println(node.getClass());
			} else  {
				System.out.println(start.toString());
				showTree(start.getFirstChild());
			}
			start = start.getNext();
		}
	}
}
