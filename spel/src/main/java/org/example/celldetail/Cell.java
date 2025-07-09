package org.example.celldetail;

import static java.util.Optional.ofNullable;

public interface Cell {

    String getAttributeId();

    boolean isDisplayCell();

    CellLocation getCellLocation();

    String getFormula();

    Object getCellValue();

    CellStyle getCellStyle();

    CellType getCellType();

    String getEvaluatedFormula();

    default boolean hasFormula(){
        return ofNullable(getFormula().isPresent());
    }

}
