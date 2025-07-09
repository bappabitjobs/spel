package org.example.context;
import org.apache.commons.math3.util.Pair;
import org.example.celldetail.SheetColumnReference;

import java.util.List;
import java.util.stream.Collectors;

public class FormulaFactory {
    static String createSum(List<Pair<String,String>> cellReferenceRanges){
       return cellReferenceRanges.stream().
               map(pair -> pair.getFirst().equals(pair.getSecond()) ? pair.getFirst() :
                       String.format("%s:%s",pair.getFirst(),pair.getSecond()))
               .collect(Collectors.joining(",","SUM(",")"));
    }
    static String createSum(String cellReferences){
        return String.format("SUM(%s",cellReferences);
    }

    static String createSumIf(SheetColumnReference attributeToSum, List<CriterionReferences> criterionReferences){
        return String.format("SUMIFS(%s,%s)",asRange(attributeToSum),
                criterionReferences.stream().map(FormulaFactory::asCriteriaRangeToCriteriaPair)
                .collect(Collectors.joining(",")));
    }

    private static String asCriteriaRangeToCriteriaPair(CriterionReferences criterionReferences){
        return String.format("%s.%s",asRange(criterionReferences.getLeft()),criterionReferences.getRight());


    }

    private static String asCriteria(CriterionReferences criterionReferences){
        return String.format("%s!%s%s%s",criterionReferences.getLeft().getColumnReference(),
                criterionReferences.getType().getSymbolType(), criterionReferences.getRight());
    }

    private static String asRange(SheetColumnReference attributeToSum){
        return String.format("%s!$%s:$%s",attributeToSum.getSheetName(),attributeToSum.getColumnReference(),
                attributeToSum.getColumnReference());
    }

    static String createRound(Object toRound,int precision){
        return String.format("ROUND(%s,%d",toRound.toString(),precision);
    }

    static Object createSubtraction(Object left,Object right){
        return String.format("%s -%s",left.toString(), right.toString());
    }

    Object createDivision(Object numerator, Object denominator){
        return String.format("IFERROR(%s/%s)",numerator.toString(), denominator.toString());
    }

    static Object createAddition(Object left, Object right){
        return String.format("%s + %s",left.toString(), right.toString());
    }

    static String createIf(CriterionReferences criterionReferences, Object trueExpr, Object falseExpr){
        return String.format("IF(%s,%s,%s)",asCriteria(criterionReferences), trueExpr.toString(), falseExpr.toString());
    }

    static String createMaxIfs(SheetColumnReference maxRange, List<CriterionReferences> criterionReferences){
        return String.format("_xlfn.MAXIFS(%s,%s)",asRange(maxRange),
                criterionReferences.stream().map(FormulaFactory::asCriteriaRangeToCriteriaPair).
                collect(Collectors.joining(",")));
    }

    static String createProductIfs(CriterionReferences criterionReferences, Object evaluateCellReference){
        return String.format("PRODUCT(IF(%s,%s,1))",
                FormulaFactory.asCriteriaRangeToCriteriaPair(criterionReferences),
                        evaluateCellReference.toString());
    }
}
