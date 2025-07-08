package org.example;

public enum EqualityType {
    EQUAL("="),
    NOT_EQUAL("!="),
    NONE("");

    private final String symbolType;

    EqualityType(String symbol){
        this.symbolType = symbol;
    }

    public String getSymbolType(){return symbolType;}




}
