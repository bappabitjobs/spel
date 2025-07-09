package org.example.context;

import org.example.celldetail.Cell;
import org.example.expr.FormulaExpression;

import java.util.List;
import java.util.Set;

import static org.example.FormulaExpressions.isPlaceholder;

public interface FormulaEvaluationContext {

List<Cell> getAllCellsInContextFor(String attributeId, Cell cellInContext);

Object getValue(String identifier);

String getCellReferenceForAttribute(Cell cellInContext, String attributeId );

default FormulaExpression replacePlaceholders(FormulaExpression originalExpression){
    Set<String> attributes = originalExpression.getAttributes();
    FormulaExpression expression = originalExpression;
    for(String attribute : attributes){
        if(isPlaceholder(attribute)){
            expression = expression.replace(attribute, getPlaceholderValue(attribute));
        }
    }
  return expression;
}

default String getPlaceholderValue(String placeholder){
    throw new IllegalStateException("value for "+ placeholder + " is not defined");
}
}
