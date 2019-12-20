package com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCsvBuilder<T> implements ICSvBuilder{
    public Iterator<T> getFileByIterator(Reader reader, Class csvClass) throws CsvBuilderException {
        try {
            return this.getCsvBean(reader,csvClass).iterator();
        } catch (RuntimeException e){
            throw new CsvBuilderException("unable to get iterator : "+e.getMessage(),
                    CsvBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }

    @Override
    public List getFileByList(Reader reader, Class csvClass) throws CsvBuilderException {
        try{
            return this.getCsvBean(reader,csvClass).parse();
        } catch (RuntimeException e) {
            throw new CsvBuilderException("unable to get the list : "+e.getMessage(),
                    CsvBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }

    private CsvToBean<T> getCsvBean(Reader reader, Class csvClass) throws CsvBuilderException {
        try {
            CsvToBeanBuilder<T> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return csvToBeanBuilder.build();
        } catch (IllegalStateException e) {
            throw new CsvBuilderException(e.getMessage(),
                    CsvBuilderException.ExceptionType.UNABLE_TO_PARSE);

        }
    }
}
