package com.epam.jwt.task3.parser;

import com.epam.jwt.task3.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final int DECRIPTION_INDEX = 5;
    private static final int PORTION_INDEX = 7;
    private static final int PRICE_INDEX = 9;
    private static Logger logger = LogManager.getLogger(XMLParserByDOM.class);

    private Menu menu;

    public static void main(String[] args) throws IOException, SAXException {
        Menu menu = new XMLParserByDOM().parseByDOM();
        menu.getSections();
    }

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
            section.setComplexDish(complexDishes);

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

            if (dishesNode.getTagName().trim().equals("dish")) {
                Dish dish = parseDish(childDishesNode);

                dishes.add(dish);
            }
        }

        return dishes;
    }

    private Dish parseDish(NodeList childDishesNode) {
        Dish dish = new Dish();

        dish.setPhoto(childDishesNode.item(PHOTO_INDEX).getNodeValue());
        dish.setNameDish(childDishesNode.item(NAME_DISH_INDEX).getNodeValue());
        dish.setDescription(childDishesNode.item(DECRIPTION_INDEX).getNodeValue());
        dish.setPortion(childDishesNode.item(PORTION_INDEX).getNodeValue());

        Node priceNode = childDishesNode.item(PRICE_INDEX);
        String nodeValue = priceNode.getNodeValue();

        dish.setPrice(nodeValue != null ? Integer.parseInt(nodeValue) : 0);

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

            if (complexDishesNode.getTagName().trim().equals("complexDish")) {
                ComplexDish complexDish = parseComplexDish(childComplexDishesNode);

                complexDishes.add(complexDish);
            }
        }
        return complexDishes;
    }

    private ComplexDish parseComplexDish(NodeList childComplexDishesNode) {
        ComplexDish complexDish = new ComplexDish();

        complexDish.setPhoto(childComplexDishesNode.item(PHOTO_INDEX).getNodeValue());
        complexDish.setNameDish(childComplexDishesNode.item(NAME_DISH_INDEX).getNodeValue());

        List<ComplexDescription> descriptions = parseComplexDescriptions(childComplexDishesNode);

        complexDish.setComplexDescription(descriptions);
        complexDish.setPortion(childComplexDishesNode.item(PORTION_INDEX).getNodeValue());

        return complexDish;
    }

    private List<ComplexDescription> parseComplexDescriptions(NodeList childComplexDishesNode) {
        List<ComplexDescription> descriptions = new ArrayList<>();
        NodeList complexDescriptions = childComplexDishesNode.item(DECRIPTION_INDEX).getChildNodes();

        int length = complexDescriptions.getLength();

        for (int i = 0; i < length; i += 4) {
            ComplexDescription description = parseComplexDescription(complexDescriptions, i);

            descriptions.add(description);
        }
        return descriptions;
    }

    private ComplexDescription parseComplexDescription(NodeList complexDescriptions, int i) {
        ComplexDescription description = new ComplexDescription();
        Node complexDescriptionNode = complexDescriptions.item(i + 1);

        if (complexDescriptionNode != null) {
            description.setIngredient(complexDescriptionNode.getNodeValue());

            String priceNodeValue = complexDescriptions.item(i + 3).getNodeValue();

            description.setPrice(priceNodeValue != null ? Integer.parseInt(priceNodeValue) : 0);
        }
        return description;

    }
}