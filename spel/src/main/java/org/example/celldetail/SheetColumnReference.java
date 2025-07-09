package org.example.celldetail;

public class SheetColumnReference {
    private final String sheetName;
    private final int column;
    private final String columnReference;


    public SheetColumnReference(String sheetName, int column, String columnReference) {
        this.sheetName = sheetName;
        this.column = column;
        this.columnReference = columnReference;
    }

    public String getSheetName() {
        return sheetName;
    }

    public int getColumn() {
        return column;
    }

    public String getColumnReference() {
        return columnReference;
    }


}
