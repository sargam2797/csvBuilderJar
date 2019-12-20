package com;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSvBuilder<T> {
    public Iterator<T> getFileByIterator(Reader reader, Class csvClass) throws CsvBuilderException;
    public List<T> getFileByList(Reader reader, Class csvClass) throws CsvBuilderException;
}
