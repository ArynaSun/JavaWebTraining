package com.epam.jwt.task1.repository.reader.Impl;

import com.epam.jwt.task1.exception.DataReaderException;
import com.epam.jwt.task1.repository.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {

    private static Logger logger = LogManager.getLogger(DataReaderImpl.class);

    private String fileName;

    public DataReaderImpl(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readData() throws DataReaderException {
        List<String> dataLines;
        Path path = Paths.get(fileName);

        try (Stream<String> lineStream = Files.lines(path)) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal("Error while opening file: " + fileName + e);
            throw new DataReaderException("Error while opening file", e);
        }

        return dataLines;
    }
}
