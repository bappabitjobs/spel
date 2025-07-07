package org.example;

import java.util.HashSet;
import java.util.Set;


public class DivisionExpression implements  FormulaExpression{
    private final FormulaExpression numerator;
    private final FormulaExpression denominator;

    public DivisionExpression(FormulaExpression numerator, FormulaExpression denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String asString() {
      return  String.format("%s / %s ", numerator.asString() , denominator.asString());
    }

    @Override
    public FormulaExpression replace(String replaceThisStr, String withThatStr) {
        return new DivisionExpression(numerator.replace(replaceThisStr,withThatStr), denominator.replace(replaceThisStr,withThatStr));
    }

    @Override
    public Set<String> getAttributes() {
        Set<String> attributes = new HashSet<>();
        attributes.addAll(numerator.getAttributes());
        attributes.addAll(denominator.getAttributes());
        return attributes;
    }
}
