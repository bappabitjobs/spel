package org.example.expr;

import java.util.Set;

public interface FormulaExpression {
    String asString();
    FormulaExpression replace(String replaceThisString, String withThat);
    Set<String> getAttributes();

}
