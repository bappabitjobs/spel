package org.example;

import java.util.Set;

public interface FormulaExpression {
    String asString();
    FormulaExpression replace(String destination, String source);
    Set<String> getAttributes();

}
