package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SumExpression implements FormulaExpression{
    private final List<String> attributesToSum;

    public SumExpression(List<String> attributesToSum) {
        this.attributesToSum = attributesToSum;
    }

    public SumExpression(String ...attributesToSum){
        this(Arrays.asList(attributesToSum));
    }

    public List<String> getAttributesToSum() {
        return attributesToSum;
    }

    @Override
    public String asString() {
        return "sum " + attributesToSum;
    }

    @Override
    public FormulaExpression replace(String replaceThisString, String withThat) {
        return new SumExpression(attributesToSum.stream()
                .map( s-> s.replace(replaceThisString,withThat)).collect(Collectors.toList()));
    }

    @Override
    public Set<String> getAttributes() {
        return new HashSet<>(attributesToSum);
    }
}
