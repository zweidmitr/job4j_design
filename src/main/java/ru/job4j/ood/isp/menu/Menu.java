package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Element> list = new ArrayList<>();

    public Menu(String name, Action action) {
        this.list.add(new Element(name, action));
    }

    public String print() {
        String result = "";
        for (Element elem : list) {
            result = elem.toString();
        }
        return result;
    }

    /**
     * находим предка по имени и добавляем потомка с указанным действием
     *
     * @param parentName
     * @param childName
     * @param action
     */
    public void add(String parentName, String childName, Action action) {
        Element parentElement = findElement(parentName);
        parentElement.add(new Element(childName, action));
    }

    /**
     * поиск элемента по имени
     *
     * @param name
     * @return
     */
    public Element findElement(String name) {
        Element result = null;
        for (Element elem : list) {
            result = elem.search(name);
            if (result != null) {
                return result;
            }
        }
        return result;
    }

    public Action select(String name) {
        return findElement(name).getAction();
    }
}
