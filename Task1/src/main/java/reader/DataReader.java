package reader;

import exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static final String DATA_TXT = "Data.txt";

    private static Logger logger = LogManager.getLogger(DataReader.class);// что-то с логером, шо делает делает гетлоггер

    public List<String> readData(String fileName) throws DataReaderException {
        List<String> dataLines;
        Path path = Paths.get(DATA_TXT);

        try (Stream<String> lineStream = Files.lines(path)) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal("Error while opening file: " + fileName + e);
            throw new DataReaderException("Error while opening file", e);
        }

        return dataLines;
    }
}
