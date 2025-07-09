package org.example.expr;

import java.util.Set;


public class BinaryCriterionExpression implements FormulaExpression{
    private final String left;
    private final String right;
    private final EqualityType equalityType;

    public BinaryCriterionExpression(String left, String right, EqualityType equalityType) {
        this.left = left;
        this.right = right;
        this.equalityType = equalityType;
    }

    @Override
    public String asString() {
        return String.format("%s %s %s",left,equalityType.getSymbolType(), right);
    }

    @Override
    public FormulaExpression replace(String replaceThisString, String withThat) {
        return new BinaryCriterionExpression(left.replace(replaceThisString,withThat),
                right.replace(replaceThisString,withThat),equalityType);
    }

    @Override
    public Set<String> getAttributes() {
        return Set.of(left,right);
    }
}
