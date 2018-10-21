package com.epam.jwt.task1.repository.reader;

import com.epam.jwt.task1.exception.DataReaderException;

import java.util.List;

public interface DataReader {

    List<String> readData() throws DataReaderException;
}
