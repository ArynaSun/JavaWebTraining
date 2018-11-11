package com.epam.jwt.task3.parser;

import com.epam.jwt.task3.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLParserBySax extends DefaultHandler {

    private static final int RESTAURANT_NAME_INDEX = 0;
    private static final int SECTION_INDEX = 0;
    private static final int BEGIN_INDEX = -1;
    private static Logger logger = LogManager.getLogger(XMLParserBySax.class);

    private Menu menu;
    private int sectionPosition = BEGIN_INDEX;
    private int dishesPosition = BEGIN_INDEX;
    private int complexDishesPosition = BEGIN_INDEX;
    private int complexDescriptionPosition = BEGIN_INDEX;
    private boolean isComplexDish;
    private String element;

    public Menu receiveResult() {
        return menu;
    }

    @Override
    public void startDocument() {

        logger.info("Parsing started");

        menu = new Menu();

        menu.setSections(new ArrayList<>());
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attributes) {
        element = localName.trim();
        switch (element) {
            case "menu":
                String restaurantName = attributes.getValue(RESTAURANT_NAME_INDEX);
                logger.info("Restaurant: " + restaurantName);
                menu.setNameRestaurant(restaurantName);

                break;
            case "section":
                String sectionName = attributes.getValue(SECTION_INDEX);
                logger.info("Section: " + sectionName);

                Section section = new Section();

                section.setName(sectionName);

                section.setComplexDish(new ArrayList<>());
                section.setDishes(new ArrayList<>());

                menu.getSections().add(section);

                sectionPosition++;

                break;
            case "dishes":
                Dish dish = new Dish();

                menu.getSections().get(sectionPosition).getDishes().add(dish);
                dishesPosition++;

                isComplexDish = false;

                break;
            case "complexDish":
                ComplexDish complexDish = new ComplexDish();

                menu.getSections().get(sectionPosition).getComplexDish().add(complexDish);
                complexDishesPosition++;

                isComplexDish = true;

                break;
            case "complexDescription":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition)
                        .setComplexDescription(new ArrayList<>());
                break;
            case "ingredient":
                ComplexDescription complexDescription = new ComplexDescription();
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition)
                        .getComplexDescription().add(complexDescription);
                complexDescriptionPosition++;
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        logger.info(localName);
        switch (localName) {
            case "complexDish":
                complexDescriptionPosition = BEGIN_INDEX;
                break;
            case "section":
                complexDishesPosition = BEGIN_INDEX;
                dishesPosition = BEGIN_INDEX;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String tagValue = new String(ch, start, length).trim();

        if (tagValue.isEmpty()) {
            return;
        }

        if (!isComplexDish) {
            handleDish(tagValue);
        } else {
            handleComplexDish(tagValue);
        }
    }

    private void handleComplexDish(String tagValue) {
        switch (element) {
            case "photo":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition).setPhoto(tagValue);
                break;
            case "dishName":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition).setNameDish(tagValue);
                break;
            case "ingredient":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition)
                        .getComplexDescription().get(complexDescriptionPosition).setIngredient(tagValue);
                break;
            case "price":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition)
                        .getComplexDescription().get(complexDescriptionPosition).setPrice(Integer.parseInt(tagValue));
                break;
            case "portion":
                menu.getSections().get(sectionPosition)
                        .getComplexDish().get(complexDishesPosition).setPortion(tagValue);
                break;
        }
    }

    private void handleDish(String tagValue) {
        switch (element) {
            case "photo":
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPhoto(tagValue);
                break;
            case "dishName":
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setNameDish(tagValue);
                break;
            case "description":
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setDescription(tagValue);
                break;
            case "portion":
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPortion(tagValue);
                break;
            case "price":
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPrice(Integer.parseInt(tagValue));
                break;
        }
    }


    @Override
    public void endDocument() {
        System.out.println(("\nParsing ended"));
    }

}
