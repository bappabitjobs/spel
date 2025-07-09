package org.example.expr;

import java.util.HashSet;
import java.util.Set;


public class SubtractionExpression implements  FormulaExpression{
    private final FormulaExpression left;
    private final FormulaExpression right;

    public SubtractionExpression(FormulaExpression left, FormulaExpression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String asString() {
        return left.asString() + " - " + right.asString();
    }

    @Override
    public FormulaExpression replace(String replaceThisStr, String withThatStr) {
        return new SubtractionExpression(left.replace(replaceThisStr,withThatStr), right.replace(replaceThisStr,withThatStr));
    }

    @Override
    public Set<String> getAttributes() {
        Set<String> attributes = new HashSet<>();
        attributes.addAll(left.getAttributes());
        attributes.addAll(right.getAttributes());
        return attributes;
    }
}
