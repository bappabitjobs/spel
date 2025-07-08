package org.example;

import java.util.HashSet;
import java.util.Set;

public class TotalSumExpression implements  FormulaExpression{

    private final String identifier;
    public TotalSumExpression(String identifier) {
         this.identifier = identifier;
    }

    @Override
    public String asString() {
        return "totalSum " + identifier;
    }

    @Override
    public FormulaExpression replace(String replaceThisString, String withThat) {
        return new TotalSumExpression(identifier.replace(replaceThisString, withThat));
    }

    @Override
    public Set<String> getAttributes() {

        Set<String> attr = new HashSet<>();
                attr.add(identifier);
                return attr;
    }
}
