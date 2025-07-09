package org.example;

public interface FormulaExpressions {
    static String createPlaceholder(String forAttr){
        return String.format("$%s$",forAttr);
    }
    static boolean isPlaceholder(String attribute){
        return attribute.matches("\\$.*\\$");
    }
}
