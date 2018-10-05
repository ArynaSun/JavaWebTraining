package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.stream.Collectors;

public class DataReader {
    private static Logger logger = LogManager.getLogger();// что-то с логером, шо делает делает гетлоггер

    public List<String> readData(String fileName) {
        List<String> data = new ArrayList<>();// может стрингс вместо дата? Тут Блинов убрал правую часть

        try (FileReader fileReader = new FileReader(fileName);//
             // BufferedReader bufferedReader = new BufferedReader(fileReader);
             //Stream<String> lineStream = bufferedReader.data(); эту строку убрал
             //data = bufferedReader.data.collect(Collectors.toList())
             Scanner scan = new Scanner(fileReader)) {
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
        } catch (IOException e) {
            logger.info(e.toString());//низя ту стринг
            //logger.fatal("Error while opening file: " fileName+ e);
            //throw new RuntimeException("Error while opening file" + e);

        }

        return data;
    }
}
