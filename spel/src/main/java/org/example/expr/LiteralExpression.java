package org.example.expr;

import java.util.Set;

public class LiteralExpression implements  FormulaExpression{


    private final String value;
    public LiteralExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }

    @Override
    public FormulaExpression replace(String withThisStr, String withThatStr) {
        return new LiteralExpression(value.replace(withThatStr,withThatStr));
    }

    @Override
    public Set<String> getAttributes() {
        return Set.of();
    }
}
