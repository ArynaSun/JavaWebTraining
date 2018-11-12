package com.epam.jwt.task3.parser;

import com.epam.jwt.task3.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class XMLParserBYStAX implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private static final int RESTAURANT_NAME_INDEX = 0;
    private static final int SECTION_INDEX = 0;
    private static final int BEGIN_INDEX = -1;
    private static final String PHOTO = "photo";
    private static final String DISH_NAME = "dishName";
    private static final String INGREDIENT = "ingredient";
    private static final String PRICE = "price";
    private static final String PORTION = "portion";
    private static final String DESCRIPTION = "description";
    private static final String SECTION = "section";
    private static final String COMPLEX_DISH = "complexDish";
    private static final String COMPLEX_DESCRIPTION = "complexDescription";
    private static final String DISHES = "dishes";
    private static final String MENU = "menu";

    private static Logger logger = LogManager.getLogger(XMLParserBYStAX.class);

    private final XMLStreamReader reader;
    private Menu menu;
    private int sectionPosition = BEGIN_INDEX;
    private int dishesPosition = BEGIN_INDEX;
    private int complexDishesPosition = BEGIN_INDEX;
    private int complexDescriptionPosition = BEGIN_INDEX;
    private boolean isComplexDish;
    private String tagName;

    public XMLParserBYStAX(InputStream inputStream) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(inputStream);
    }

    public Menu parseByStAX() throws IOException, XMLStreamException {
        init();
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLEvent.START_ELEMENT:
                    startElement(reader);
                    break;
                case XMLEvent.END_ELEMENT:
                    endElement(reader);
                    break;
            }
        }
        return menu;
    }

    private void endElement(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case COMPLEX_DISH:
                complexDescriptionPosition = BEGIN_INDEX;
                break;
            case SECTION:
                complexDishesPosition = BEGIN_INDEX;
                dishesPosition = BEGIN_INDEX;
        }
    }

    private void init() {
        menu = new Menu();
        menu.setSections(new ArrayList<>());
    }

    private void startElement(XMLStreamReader reader) throws XMLStreamException {
        tagName = reader.getLocalName();
        String tagValue;
        switch (tagName) {
            case MENU:
                String restaurantName = reader.getAttributeValue(RESTAURANT_NAME_INDEX);
                menu.setNameRestaurant(restaurantName);

                break;
            case SECTION:
                String sectionName = reader.getAttributeValue(SECTION_INDEX);

                Section section = new Section();

                section.setName(sectionName);
                section.setComplexDishes(new ArrayList<>());
                section.setDishes(new ArrayList<>());

                menu.getSections().add(section);
                sectionPosition++;

                break;
            case DISHES:
                Dish dish = new Dish();

                menu.getSections().get(sectionPosition).getDishes().add(dish);
                dishesPosition++;

                isComplexDish = false;
                break;
            case COMPLEX_DISH:
                ComplexDish complexDish = new ComplexDish();

                menu.getSections().get(sectionPosition).getComplexDishes().add(complexDish);
                complexDishesPosition++;

                isComplexDish = true;

                break;
            case COMPLEX_DESCRIPTION:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition)
                        .setComplexDescriptions(new ArrayList<>());
                break;
            case INGREDIENT:
                ComplexDescription complexDescription = new ComplexDescription();
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition)
                        .getComplexDescriptions().add(complexDescription);
                complexDescriptionPosition++;
                tagValue = reader.getElementText();
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition)
                        .getComplexDescriptions().get(complexDescriptionPosition).setIngredient(tagValue);
            case DISH_NAME:
                try {
                    tagValue = reader.getElementText();
                } catch (Exception e) {
                    tagValue = "";
                }
                if (isComplexDish) {
                    menu.getSections().get(sectionPosition)
                            .getComplexDishes().get(complexDishesPosition).setNameDish(tagValue);
                } else {
                    menu.getSections().get(sectionPosition)
                            .getDishes().get(dishesPosition).setNameDish(tagValue);
                }
                break;
            case PHOTO:
                tagValue = reader.getElementText();
                if (isComplexDish) {
                    menu.getSections().get(sectionPosition)
                            .getComplexDishes().get(complexDishesPosition).setPhoto(tagValue);
                } else {
                    menu.getSections().get(sectionPosition)
                            .getDishes().get(dishesPosition).setPhoto(tagValue);
                }
                break;
            case DESCRIPTION:
                tagValue = reader.getElementText();
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setDescription(tagValue);
                break;
            case PORTION:
                tagValue = reader.getElementText();
                if (isComplexDish) {
                    menu.getSections().get(sectionPosition)
                            .getComplexDishes().get(complexDishesPosition).setPortion(tagValue);
                } else {
                    menu.getSections().get(sectionPosition)
                            .getDishes().get(dishesPosition).setPortion(tagValue);
                }
                break;
            case PRICE:
                tagValue = reader.getElementText();
                if (isComplexDish) {
                    menu.getSections().get(sectionPosition)
                            .getComplexDishes().get(complexDishesPosition)
                            .getComplexDescriptions().get(complexDescriptionPosition).setPrice(tagValue.isEmpty() ? 0 : Integer.parseInt(tagValue));
                } else {
                    menu.getSections().get(sectionPosition)
                            .getDishes().get(dishesPosition).setPrice(tagValue.isEmpty() ? 0 : Integer.parseInt(tagValue));
                }
                break;
        }
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                logger.info("Error " + e.getMessage());
            }
        }

    }
}
