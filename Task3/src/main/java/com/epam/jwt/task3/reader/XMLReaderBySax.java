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

    Menu menu;
    int sectionPosition = -1;
    List<Integer> dishesPositions;
    List<Integer> complexDishesPositions;
    List<Integer> complexDescriptionPositions;
    private String element;

    public Menu receiveResult() {
        return menu;
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
        menu = new Menu();
        menu.setSections(new ArrayList<>());
        dishesPositions = new ArrayList<>();
        complexDishesPositions = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attributes) {
        element = localName;
        switch (element){
            case "menu":
                menu.setNameRestaurant(attributes.getValue(0));
                break;
            case "section":
                Section section = new Section();
                section.setName(attributes.getValue(0));
                section.setComplexDish(new ArrayList<>());
                section.setDish(new ArrayList<>());
                menu.getSections().add(section);
                sectionPosition++;
                complexDishesPositions.add(-1);
                dishesPositions.add(-1);
                break;
            case "dish":
                Dish dish = new Dish();
                menu.getSections().get(sectionPosition).getDish().add(dish);
                dishesPositions.set(sectionPosition, dishesPositions.get(sectionPosition) + 1);
                break;
            case "complexDish":
                ComplexDish complexDish = new ComplexDish();
                menu.getSections().get(sectionPosition).getComplexDish().add(complexDish);
                complexDishesPositions.set(sectionPosition, complexDishesPositions.get(sectionPosition) + 1);
                break;
            case "complexDescription":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPositions.get(sectionPosition))
                        .setComplexDescription(new ArrayList<>());
                break;
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        System.out.println((localName));
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String tagValue = new String(ch, start, length).trim();
        if (tagValue.isEmpty()){
            return;
        }
        switch (element){
            case "photo":
                menu.getSections().get(sectionPosition)
                        .getDish().get(dishesPositions.get(sectionPosition)).setPhoto(tagValue);
                break;
            case "dishName":
                menu.getSections().get(sectionPosition)
                        .getDish().get(dishesPositions.get(sectionPosition)).setNameDish(tagValue);
                break;
            case "description":
                menu.getSections().get(sectionPosition)
                        .getDish().get(dishesPositions.get(sectionPosition)).setDescription(tagValue);
                break;
            case "portion":
                menu.getSections().get(sectionPosition)
                        .getDish().get(dishesPositions.get(sectionPosition)).setPortion(tagValue);
                break;
            case "price":
                menu.getSections().get(sectionPosition)
                        .getDish().get(dishesPositions.get(sectionPosition)).setPrice(Integer.parseInt(tagValue));
                break;
            case "ingredient":
                break;
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

            Menu menu = readerBySax.receiveResult();
            menu.getSections();
        } catch (SAXException e) {
            System.out.println("Ошибка SAX парсера");
        } catch (IOException e) {
            System.out.println("Ошибка IO потока");
        };

    }

}
