package com.epam.jwt.task3.reader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.nio.file.Files;

public class XMLReaderBYStAX implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public XMLReaderBYStAX(InputStream inputStream) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(inputStream);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    @Override
    public void close() {
        if (reader != null){
            try {
                reader.close();
            }catch (XMLStreamException e){
                System.out.println(" Error");
            }
        }

    }
}
