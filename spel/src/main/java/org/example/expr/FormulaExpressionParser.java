package org.example.expr;

import org.springframework.expression.spel.SpelNode;
import org.springframework.expression.spel.ast.PropertyOrFieldReference;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class FormulaExpressionParser {

    private final SpelExpressionParser parser = new SpelExpressionParser();

    public FormulaExpression parse(String formula){
        String newFormula = formula.trim();
        if(newFormula.startsWith("SUM ") || newFormula.startsWith("totalSum ")){
            final StringTokenizer tokenizer = new StringTokenizer(newFormula);
            String token = tokenizer.nextToken();
            if(token.equals("SUM ")){
                return parseSum(tokenizer);
            }else if(token.equals("totalSum")){
                return parseTotalSum(tokenizer);
            }
        }else{
            return parseExpression(newFormula);
        }
      return null;
    }
private FormulaExpression parseTotalSum(StringTokenizer tokenizer){
        if(!tokenizer.hasMoreTokens()){
            throw new IllegalStateException("More tokens required to sum");
        }
        final String identifier = tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()){
            throw new IllegalStateException(" Already token found");
        }
        return new TotalSumExpression(identifier);
}


    private FormulaExpression parseExpression(String expression){
        try {
            final SpelExpression parseExpression = parser.parseRaw(expression);
            SpelNode ast = parseExpression.getAST();
            if (ast instanceof PropertyOrFieldReference) {
                return new IdentifierExpression(expression);

            }
            final Set<String> properties = new HashSet<>();
            visit(ast, properties);
            return new ArithmeticExpression(expression, properties);
        } catch (Exception e) {
            log.warn("Parsing of expression failed", expression, e);
            return null;
        }

        }

        private SumExpression parseSum(StringTokenizer tokenizer){
          if(!tokenizer.hasMoreTokens()){
              throw new IllegalStateException("More tokens are need to sum");
          }
          final String identifier = tokenizer.nextToken();
          if(tokenizer.hasMoreTokens()){
              throw new IllegalStateException("Found more attribute to SUm");
          }
          return new SumExpression(identifier);
        }

    private void visit(final SpelNode parentNode, final Set<String> intermediateVariableValues){
        if(parentNode instanceof  PropertyOrFieldReference){
            final PropertyOrFieldReference ref = (PropertyOrFieldReference) parentNode;
            final String name = ref.getName();
            intermediateVariableValues.add(name);
        } else{
            for(int i=0 ; i< parentNode.getChildCount();i++){
                visit(parentNode.getChild(i),intermediateVariableValues);
            }
        }
    }
}
