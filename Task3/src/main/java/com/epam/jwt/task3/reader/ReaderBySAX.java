package com.epam.jwt.task3.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ReaderBySAX {

    private static Logger logger = LogManager.getLogger(ReaderBySAX.class);


    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            logger.error("parsing error" + e);
        } catch (SAXException e) {
            logger.error("ошибка SAX парсера: " + e);
        }

        DefaultHandler handler = new DefaultHandler() {
            boolean bPhoto = false;
            boolean bDishName = false;
            boolean bDescription = false;
            boolean pPortion = false;
            boolean bPrice = false;

            public void startElement(String namespaceURI, String localName,
                                     String qName, Attributes attributes) throws SAXException {
                String Element = localName;

                for (int i = 0; i < attributes.getLength(); i++) {

                    Element += " " + attributes.getLocalName(i) + " = " + attributes.getValue(i);
                }
                logger.info(Element.trim());

                if (qName.equals("photo")) {
                    bPhoto = true;
                }

                if (qName.equals("dishName")) {
                    bDishName = true;
                }

                if (qName.equals("description")) {
                    bDescription = true;
                }

                if (qName.equals("portion")) {
                    pPortion = true;
                }

                if (qName.equals("price")) {
                    bPrice = true;
                }
            }

            public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
                logger.info(localName);
            }

            public void characters(char[] ch, int start, int length) {

                if (bPhoto) {
                    logger.info("photo: " + new String(ch, start, length));
                    bPhoto = false;
                }

                if (bDishName) {
                    logger.info("dishName: " + new String(ch, start, length));
                    bDishName = false;
                }

                if (bDescription) {
                    logger.info("description: " + new String(ch, start, length));
                    bDescription = false;
                }
                if (pPortion) {
                    logger.info("portion: " + new String(ch, start, length));
                    pPortion = false;
                }

                if (bPrice) {
                    logger.info("price: " + new String(ch, start, length));
                    bPrice = false;
                }
            }
        };

        try {
            saxParser.parse("resources/menu.xml", handler);
        } catch (SAXException e) {
            logger.error("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            logger.error("ошибка IO потока: " + e);
        }
    }
}

