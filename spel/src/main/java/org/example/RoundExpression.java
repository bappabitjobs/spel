package org.example;

import java.util.Set;

public class RoundExpression implements FormulaExpression{
    private final FormulaExpression expression;
    private final int precision;

    public RoundExpression(FormulaExpression expression, int precision) {
        this.expression = expression;
        this.precision = precision;
    }

    public FormulaExpression getExpression() {
        return expression;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public String asString() {
        return "round( " + expression.asString() + "," + precision +  ")";
    }

    @Override
    public FormulaExpression replace(String replaceThisString, String withThat) {
        return new RoundExpression(expression.replace(replaceThisString,withThat),precision);
    }

    @Override
    public Set<String> getAttributes() {
        return expression.getAttributes();
    }
}
