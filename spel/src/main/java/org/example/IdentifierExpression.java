package org.example;

import java.util.Set;

public class IdentifierExpression implements  FormulaExpression{
    public IdentifierExpression(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private final String identifier;

    @Override
    public String asString() {
        return identifier;
    }

    @Override
    public FormulaExpression replace(String withThisStr, String withThatStr) {
        return new IdentifierExpression(identifier.replace(withThatStr,withThatStr));
    }

    @Override
    public Set<String> getAttributes() {
        return Set.of();
    }
}
