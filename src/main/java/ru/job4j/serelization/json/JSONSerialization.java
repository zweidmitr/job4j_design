package ru.job4j.serelization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONSerialization {
    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-1111\"}");

        /* JSONArray from ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* преобразуем person to jsonString */
        System.out.println(new JSONObject(person).toString());
        System.out.println();
    }
}
