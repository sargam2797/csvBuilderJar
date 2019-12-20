package com;

public class CSVBuilderFactory {
    public static ICSvBuilder createCsvBuilder() {
        return new OpenCsvBuilder();
    }
}
