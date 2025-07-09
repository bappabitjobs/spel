package org.example.celldetail;

public class CellLocation {
    private final int row;
    private final int column;
    private final String cellReference;

    public CellLocation(int row, int column, String cellReference) {
        this.row = row;
        this.column = column;
        this.cellReference = cellReference;
    }

    @Override
    public String toString() {
        return "CellLocation{" +
                "row=" + row +
                ", column=" + column +
                ", cellReference='" + cellReference + '\'' +
                '}';
    }

    public int getRow() {
        return row;
    }
}
