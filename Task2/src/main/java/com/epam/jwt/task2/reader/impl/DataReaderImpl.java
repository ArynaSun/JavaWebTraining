package com.epam.jwt.task2.reader.impl;

import com.epam.jwt.task2.reader.DataReader;
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

    public String readData() {
        List<String> lines;
        Path path = Paths.get(fileName);

        try (Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal("Error while opening file: " + fileName + e);
            throw new RuntimeException("Error while opening file", e);
        }
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < lines.size(); i++) {
            buffer.append(lines.get(i));
            buffer.append("\n");
        }
        return buffer.toString();
    }
}




