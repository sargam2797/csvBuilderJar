package com;

public class CsvBuilderException extends Exception {
    public enum ExceptionType {
        UNABLE_TO_PARSE
    } public ExceptionType type;

    public CsvBuilderException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
