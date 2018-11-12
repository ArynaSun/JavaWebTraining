package com.epam.jwt.task3.parser;

import com.epam.jwt.task3.entity.*;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParserByDOM {

    private static final String RESOURCES_MENU_XML = "resources/menu.xml";
    private static final String RESTAURANT = "restaurant";
    private static final String SECTION_NAME = "name";
    private static final int PHOTO_INDEX = 1;
    private static final int NAME_DISH_INDEX = 3;
    private static final int DESCRIPTION_INDEX = 5;
    private static final int PORTION_INDEX = 7;
    private static final int PRICE_INDEX = 9;
    private static final String DISHES = "dishes";
    private static final String COMPLEX_DISH = "complexDish";

    private Menu menu;

    public Menu parseByDOM() throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse(RESOURCES_MENU_XML);

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        menu = new Menu();
        menu.setNameRestaurant(root.getAttribute(RESTAURANT));

        List<Section> sections = parseSections(root);
        menu.setSections(sections);

        return menu;
    }

    private List<Section> parseSections(Element root) {
        List<Section> sections = new ArrayList<>();

        NodeList childNodes = root.getChildNodes();
        int length = childNodes.getLength();

        for (int i = 0; i < length; i++) {

            Node node = childNodes.item(i);

            if (!(node instanceof Element)) {
                continue;
            }

            Section section = new Section();
            Element sectionNode = (Element) node;

            section.setName(sectionNode.getAttribute(SECTION_NAME).trim());

            List<Dish> dishes = parseDishes(sectionNode);
            List<ComplexDish> complexDishes = parseComplexDishes(sectionNode);

            section.setDishes(dishes);
            section.setComplexDishes(complexDishes);

            sections.add(section);
        }
        return sections;
    }

    private List<Dish> parseDishes(Element sectionNode) {
        List<Dish> dishes = new ArrayList<>();
        NodeList dishesNodes = sectionNode.getChildNodes();

        int length = dishesNodes.getLength();

        for (int i = 0; i < length; i++) {
            Node dishNode = dishesNodes.item(i);

            if (!(dishNode instanceof Element)) {
                continue;
            }

            Element dishesNode = (Element) dishNode;
            NodeList childDishesNode = dishesNode.getChildNodes();

            if (dishesNode.getTagName().trim().equals(DISHES)) {
                Dish dish = parseDish(childDishesNode);

                dishes.add(dish);
            }
        }

        return dishes;
    }

    private Dish parseDish(NodeList childDishesNode) {
        Dish dish = new Dish();

        dish.setPhoto(childDishesNode.item(PHOTO_INDEX).getTextContent());
        dish.setNameDish(childDishesNode.item(NAME_DISH_INDEX).getTextContent());
        dish.setDescription(childDishesNode.item(DESCRIPTION_INDEX).getTextContent());
        dish.setPortion(childDishesNode.item(PORTION_INDEX).getTextContent());

        Node priceNode = childDishesNode.item(PRICE_INDEX);
        String nodeValue = priceNode.getTextContent();

        dish.setPrice(!nodeValue.isEmpty() ? Integer.parseInt(nodeValue) : 0);

        return dish;
    }

    private List<ComplexDish> parseComplexDishes(Element sectionNode) {
        List<ComplexDish> complexDishes = new ArrayList<>();
        NodeList dishesNodes = sectionNode.getChildNodes();

        int length = dishesNodes.getLength();

        for (int i = 0; i < length; i++) {
            Node complexDishNode = dishesNodes.item(i);

            if (!(complexDishNode instanceof Element)) {
                continue;
            }

            Element complexDishesNode = (Element) dishesNodes.item(i);
            NodeList childComplexDishesNode = complexDishesNode.getChildNodes();

            if (complexDishesNode.getTagName().trim().equals(COMPLEX_DISH)) {
                ComplexDish complexDish = parseComplexDish(childComplexDishesNode);

                complexDishes.add(complexDish);
            }
        }
        return complexDishes;
    }

    private ComplexDish parseComplexDish(NodeList childComplexDishesNode) {
        ComplexDish complexDish = new ComplexDish();

        complexDish.setPhoto(childComplexDishesNode.item(PHOTO_INDEX).getTextContent());
        complexDish.setNameDish(childComplexDishesNode.item(NAME_DISH_INDEX).getTextContent());

        List<ComplexDescription> descriptions = parseComplexDescriptions(childComplexDishesNode);

        complexDish.setComplexDescriptions(descriptions);
        complexDish.setPortion(childComplexDishesNode.item(PORTION_INDEX).getTextContent());

        return complexDish;
    }

    private List<ComplexDescription> parseComplexDescriptions(NodeList childComplexDishesNode) {
        List<ComplexDescription> descriptions = new ArrayList<>();
        NodeList complexDescriptions = childComplexDishesNode.item(DESCRIPTION_INDEX).getChildNodes();

        int length = complexDescriptions.getLength();

        for (int i = 0; i < length; i += 4) {
            ComplexDescription description = parseComplexDescription(complexDescriptions, i);

            if (description != null) {
                descriptions.add(description);
            }
        }
        return descriptions;
    }

    private ComplexDescription parseComplexDescription(NodeList complexDescriptions, int i) {
        ComplexDescription description = null;
        Node complexDescriptionNode = complexDescriptions.item(i + 1);

        if (complexDescriptionNode != null) {
            description = new ComplexDescription();
            description.setIngredient(complexDescriptionNode.getTextContent());

            String priceNodeValue = complexDescriptions.item(i + 3).getTextContent();

            description.setPrice(!priceNodeValue.isEmpty() ? Integer.parseInt(priceNodeValue) : 0);
        }
        return description;

    }
}