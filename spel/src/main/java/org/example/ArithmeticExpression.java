package org.example;

import java.util.Set;
import java.util.stream.Collectors;


public class ArithmeticExpression implements  FormulaExpression{
    private final String expression ;
    private final Set<String> attributesInExpression;

    public ArithmeticExpression(String expression, Set<String> attributesInExpression){
        this.expression = expression;
        this.attributesInExpression = attributesInExpression;
    }

    public String getExpression() {
        return expression;
    }

    public Set<String> getAttributesInExpression() {
        return attributesInExpression;
    }

    @Override
    public String asString() {
        return expression;
    }

    @Override
    public FormulaExpression replace(String replaceThisStr, String withThatStr) {
        return new ArithmeticExpression(expression.replace(replaceThisStr,withThatStr),
                attributesInExpression.stream().map(s -> s.replace(replaceThisStr,withThatStr)).collect(Collectors.toSet()));
    }

    @Override
    public Set<String> getAttributes() {
        return attributesInExpression;
    }
}
