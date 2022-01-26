package ru.job4j.ood.isp.menu;

import java.util.List;

public class Menu {

    List<Element> list;

    public Menu(List<Element> list) {
        this.list = list;
    }

    public void print() {
        for (Element elem : list) {
            System.out.println(elem);
        }
    }

    /**
     * находим предка по имени и добавляем потомка с указанным действием
     *
     * @param parentName
     * @param childName
     * @param action
     */
    void add(String parentName, String childName, Action action) {
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
