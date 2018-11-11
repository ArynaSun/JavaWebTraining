package com.epam.jwt.task3.reader;

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

public class XMLReaderByDOM {

    private static final int INDEX = 0;

    public Menu readByDOM() throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse("resources/menu.xml");
        Document document = parser.getDocument();

        Element root = document.getDocumentElement();

        Menu menu = new Menu();

        menu.setNameRestaurant(root.getAttribute("restaurant"));

        List<Section> sections = new ArrayList<>();

        NodeList childNodes = root.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            System.out.println("i = " + i);
            Node item = childNodes.item(i);
            if (!(item instanceof Element)) {
                continue;
            }
            Section section = new Section();
            Element sectionNode = (Element) item;
            section.setName(sectionNode.getAttribute("name").trim());

            List<Dish> dishes = new ArrayList<>();
            List<ComplexDish> complexDishes = new ArrayList<>();

            NodeList dishesNodes = sectionNode.getChildNodes();
            int length1 = dishesNodes.getLength();
            for (int j = 0; j < length1; j++) {
                System.out.println("j = " + j);
                Node item1 = dishesNodes.item(j);
                if (!(item1 instanceof Element)) {
                    continue;
                }
                Element dishesNode = (Element) item1;
                NodeList childDishesNode = dishesNode.getChildNodes();

                Element complexDishesNode = (Element) dishesNodes.item(j);
                NodeList childComplexDishesNode = complexDishesNode.getChildNodes();

                if (dishesNode.getTagName().trim().equals("dish")) {
                    Dish dish = new Dish();

                    dish.setPhoto(childDishesNode.item(1).getNodeValue());
                    dish.setNameDish(childDishesNode.item(3).getNodeValue());
                    dish.setDescription(childDishesNode.item(5).getNodeValue());
                    dish.setPortion(childDishesNode.item(7).getNodeValue());

                    Node item2 = childDishesNode.item(9);

                    String nodeValue = item2.getNodeValue();

                    dish.setPrice(nodeValue != null ? Integer.parseInt(nodeValue) : 0);
                    dishes.add(dish);
                } else if (complexDishesNode.getTagName().trim().equals("complexDish")) {
                    ComplexDish complexDish = new ComplexDish();
                    complexDish.setPhoto(childComplexDishesNode.item(1).getNodeValue());
                    complexDish.setNameDish(childComplexDishesNode.item(3).getNodeValue());
                    NodeList complexDescription = childComplexDishesNode.item(5).getChildNodes();
                    List<ComplexDescription> descriptions = new ArrayList<>();
                    for (int k = 0; k < complexDescription.getLength(); k += 4) {
                        System.out.println("k = " + k);
                        ComplexDescription description = new ComplexDescription();
                        Node item3 = complexDescription.item(k + 1);
                        if (item3 == null) {
                            continue;
                        }
                        String nodeValue = item3.getNodeValue();
                        description.setIngredient(nodeValue);
                        String item2 = complexDescription.item(k + 3).getNodeValue();
                        description.setPrice(item2 != null ? Integer.parseInt(item2) : 0);
                        descriptions.add(description);
                    }
                    complexDish.setComplexDescription(descriptions);
                    complexDish.setPortion(childComplexDishesNode.item(7).getNodeValue());
                    complexDishes.add(complexDish);
                }
            }
            section.setDish(dishes);
            section.setComplexDish(complexDishes);
            sections.add(section);
        }

        menu.setSections(sections);

        return menu;
    }
}