package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * шаблон элемента, в листе хранятся потомки
 */
public class Element {
    private List<Element> allElements = new ArrayList<>();
    private Action action;
    private String name;

    public Element(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return this.name;
    }

    public Action getAction() {
        return this.action;
    }

    public void add(Element elem) {
        allElements.add(elem);
    }

    public List<Element> getList() {
        return this.allElements;
    }

    /**
     * поиск элемента по имени
     *
     * @param name
     * @return Element
     */
    public Element search(String name) {
        Element result = null;
        if (name.equals(this.name)) {
            result = this;
        } else {
            for (Element elem : allElements) {
                result = elem.search(name);
                if (result != null) {
                    return result;
                }
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (Element elem : allElements) {
            sb.append(System.lineSeparator());
            sb.append(elem.toString());
        }
        return sb.toString();
    }
}
