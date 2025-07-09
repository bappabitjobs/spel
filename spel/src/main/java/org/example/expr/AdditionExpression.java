package org.example.expr;

import java.util.HashSet;
import java.util.Set;


public class AdditionExpression implements  FormulaExpression{
    private final FormulaExpression left;
    private final FormulaExpression right;

    public AdditionExpression(FormulaExpression left, FormulaExpression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String asString() {
        return left.asString() + " +" + right.asString();
    }

    @Override
    public FormulaExpression replace(String replaceThisStr, String withThatStr) {
        return new AdditionExpression(left.replace(replaceThisStr,withThatStr), right.replace(replaceThisStr,withThatStr));
    }

    @Override
    public Set<String> getAttributes() {
        Set<String> attributes = new HashSet<>();
        attributes.addAll(left.getAttributes());
        attributes.addAll(right.getAttributes());
        return attributes;
    }
}
