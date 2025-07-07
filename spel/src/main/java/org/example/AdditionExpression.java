package org.example;

import java.util.HashSet;
import java.util.Set;


public class AdditionExpression implements  FormulaExpression{
    FormulaExpression left;
    FormulaExpression right;

    public AdditionExpression(FormulaExpression left, FormulaExpression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String asString() {
        return left.asString() + " " + right.asString();
    }

    @Override
    public FormulaExpression replace(String destination, String source) {
        return new AdditionExpression(left.replace(destination,source), right.replace(destination,source));
    }

    @Override
    public Set<String> getAttributes() {
        Set<String> attributes = new HashSet<>();
        attributes.addAll(left.getAttributes());
        attributes.addAll(right.getAttributes());
        return attributes;
    }
}
