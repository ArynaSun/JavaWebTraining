package com.epam.jwt.task3.parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class XMLParserBYStAX implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public XMLParserBYStAX(InputStream inputStream) throws XMLStreamException {
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