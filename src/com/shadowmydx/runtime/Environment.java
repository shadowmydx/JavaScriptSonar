package com.shadowmydx.runtime;

import com.shadowmydx.basic.BasicItem;
import com.shadowmydx.basic.JsFunction;

import java.util.*;

/**
 * Created by WULI5 on 3/16/2017.
 */
public class Environment {
    private static Stack<String> runtimeStack = new Stack<String>();
    private static List<Environment> runtimeEnv = new ArrayList<Environment>();
    private Map<String, BasicItem> localEnv = new HashMap<String, BasicItem> ();
    private Environment fatherEnv;

    public Environment getFatherEnv() {
        return fatherEnv;
    }

    public static void callFunction(JsFunction function, Environment env) {
        runtimeEnv.add(env);
        runtimeStack.push(function.hashCode() + "");
    }

    public static void returnFunction() {
        runtimeEnv.remove(runtimeEnv.size() - 1);
        runtimeStack.pop();
    }

    public static boolean searchSpecifyFunction(JsFunction function) {
        for (String single : runtimeStack) {
            if ((function.hashCode() + "").equals(single)) {
                return true;
            }
        }
        return false;
    }

    public static String getTopFunction() {
        return runtimeStack.peek();
    }

    public void setFatherEnv(Environment fatherEnv) {
        this.fatherEnv = fatherEnv;
    }

    public void addMember(String key, BasicItem value) {
        localEnv.put(key, value);
    }

    public BasicItem getMember(String key) {
        if (!localEnv.containsKey(key)) {
            return fatherEnv.getMember(key);
        }
        return localEnv.get(key);
    }

    public void deleteMember(String key) {
        localEnv.remove(key);
    }

    public Environment copy() {
        Environment env = new Environment();
        for (String key : localEnv.keySet()) {
            env.addMember(key, localEnv.get(key));
        }
        if (fatherEnv != null) {
            env.setFatherEnv(fatherEnv.copy());
        }
        return env;
    }

    public static void main(String[] args) {
        Stack<String> test = new Stack<>();
        test.push("ddd");
        test.push("dddd");
        System.out.println(test.peek());
        for (String item : test) {
            System.out.println(item);
        }

    }
}
