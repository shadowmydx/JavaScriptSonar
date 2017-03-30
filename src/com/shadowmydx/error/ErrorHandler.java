package com.shadowmydx.error;

import org.mozilla.javascript.ast.AstNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WULI5 on 3/17/2017.
 */
public class ErrorHandler {

    private static List<JsError> errors = new ArrayList<JsError>();
    private static List<JsError> warnings = new ArrayList<JsError>();
    private static String handleFile;

    public static String getHandleFile() {
        return handleFile;
    }

    public static void setHandleFile(String handleFile) {
        ErrorHandler.handleFile = handleFile;
    }

    public static void notifyError(JsError error) {
        errors.add(error);
    }

    public static void notifyWarning(JsError warning) {
        warnings.add(warning);
    }

    public static void report() {
        for (JsError error : errors) {
            AstNode node = error.getNode();
            System.out.println("ERROR: In line " + node.getLineno() + ":");
            System.out.println(node.toSource() + "  " + error.getMsg());
        }

        for (JsError warning : warnings) {
            AstNode node = warning.getNode();
            System.out.println("WARNING: IN LINE " + node.getLineno() + ":");
            System.out.println(node.toSource() + " " + warning.getMsg());
        }
    }

}
