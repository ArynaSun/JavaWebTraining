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
            case MENU:
                String restaurantName = attributes.getValue(RESTAURANT_NAME_INDEX);
                logger.info("Restaurant: " + restaurantName);
                menu.setNameRestaurant(restaurantName);

                break;
            case SECTION:
                String sectionName = attributes.getValue(SECTION_INDEX);
                logger.info("Section: " + sectionName);

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
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        logger.info(localName);
        switch (localName) {
            case COMPLEX_DISH:
                complexDescriptionPosition = BEGIN_INDEX;
                break;
            case SECTION:
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
            case PHOTO:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition).setPhoto(tagValue);
                break;
            case DISH_NAME:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition).setNameDish(tagValue);
                break;
            case INGREDIENT:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition)
                        .getComplexDescriptions().get(complexDescriptionPosition).setIngredient(tagValue);
                break;
            case PRICE:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition)
                        .getComplexDescriptions().get(complexDescriptionPosition).setPrice(Integer.parseInt(tagValue));
                break;
            case PORTION:
                menu.getSections().get(sectionPosition)
                        .getComplexDishes().get(complexDishesPosition).setPortion(tagValue);
                break;
        }
    }

    private void handleDish(String tagValue) {
        switch (element) {
            case PHOTO:
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPhoto(tagValue);
                break;
            case DISH_NAME:
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setNameDish(tagValue);
                break;
            case DESCRIPTION:
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setDescription(tagValue);
                break;
            case PORTION:
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPortion(tagValue);
                break;
            case PRICE:
                menu.getSections().get(sectionPosition)
                        .getDishes().get(dishesPosition).setPrice(Integer.parseInt(tagValue));
                break;
        }
    }


    @Override
    public void endDocument() {
        logger.info("\nParsing ended");
    }

}
