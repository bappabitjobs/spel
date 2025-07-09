package org.example.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.celldetail.SheetColumnReference;
import org.example.expr.EqualityType;

@Data
@RequiredArgsConstructor
public class CriterionReferences {
    private final SheetColumnReference left;
    private final String right;
    private final EqualityType type;

    public SheetColumnReference getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public EqualityType getType() {
        return type;
    }
}
