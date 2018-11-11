package com.epam.jwt.task3.reader;

import com.epam.jwt.task3.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReaderBySax extends DefaultHandler {

//    private static Logger logger = LogManager.getLogger(XMLReaderBySax.class);

    Menu menu = new Menu();
    Section section = new Section();
    Dish dish = new Dish();
    ComplexDish complexDish = new ComplexDish();
    ComplexDescription complexDescription = new ComplexDescription();
    private String element;

    public Menu receiveResult() {
        return menu;
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attributes) {
        element = localName;

        for (int i = 0; i < attributes.getLength(); i++) {

            element += " " + attributes.getLocalName(i) + " = " + attributes.getValue(i);
        }
        System.out.println((element.trim()));
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        System.out.println((localName));
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        List<Dish> dishes = new ArrayList<>();
        //dishes.add(new Dish());

        if (element.equals("dish")) {
            section.setDish(dishes);
        }

        if (element.equals("photo")) {
            dish.setPhoto(new String(ch, start, length));
        }

        if (element.equals("nameDish")) {
            dish.setNameDish(new String(ch, start, length));
        }

        if (element.equals("description")) {
            dish.setDescription(new String(ch, start, length));
        }

        if (element.equals("portion")) {
            dish.setPortion(new String(ch, start, length));
        }

        if (element.equals("price")) {
            dish.setPrice(new Integer(new String(ch, start, length)));
        }

        dishes.add(dish);
        //System.out.println(dishes);

        List<ComplexDish> complexDishes = new ArrayList<>();

        if (element.equals("complexDish")) {
            section.setComplexDish(complexDishes);
        }

        if (element.equals("photo")) {
            complexDish.setPhoto(new String(ch, start, length));
        }

        if (element.equals("nameDish")) {
            complexDish.setNameDish(new String(ch, start, length));
        }

        List<ComplexDescription> complexDescriptions = new ArrayList<>();

        if (element.equals("ingredient")) {
            complexDescription.setIngredient(new String(ch, start, length));
        }
        if (element.equals("price")) {
            complexDescription.setPrice(new Integer(new String(ch, start, length)));
        }

        complexDescriptions.add(complexDescription);

        if (element.equals(("complexDescription"))) {
            complexDish.setComplexDescription(complexDescriptions);
        }
    }


    @Override
    public void endDocument() {
        System.out.println(("\nParsing ended"));
    }

    public static void main(String[] args) {

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            XMLReaderBySax readerBySax = new XMLReaderBySax();

            xmlReader.setContentHandler(readerBySax);
            xmlReader.parse("resources/menu.xml");
        } catch (SAXException e) {
            System.out.println("Ошибка SAX парсера");
        } catch (IOException e) {
            System.out.println("Ошибка IO потока");
        }

    }

}
