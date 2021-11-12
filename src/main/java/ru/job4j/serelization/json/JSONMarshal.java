package ru.job4j.serelization.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMarshal {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonJob4j = new JSONObject("{\"courseName\":\"job4j.ru\"}");
        System.out.println(jsonJob4j);

        /* JSONArray из Array */
        int[] array = new int[]{2, 3};
        JSONArray jsonArray = new JSONArray(array);
        System.out.println(jsonArray);

        /* JSONObject напрямую методом put */
        Target myTarget =
                new Target("way", true, 100,
                        new Job4j("job4j.ru/profile"), 1, 2, 3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", myTarget.getName());
        jsonObject.put("desire", myTarget.isDesire());
        jsonObject.put("daysCount", myTarget.getDaysCount());
        jsonObject.put("courseNa", jsonJob4j);
        jsonObject.put("courseSt", jsonArray);

        /* show in console */
        System.out.println(jsonObject);
    }
}
