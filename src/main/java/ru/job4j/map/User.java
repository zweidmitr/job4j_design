package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User ein = new User("job4jM", 200, new GregorianCalendar(2021, 10, 29));
        User zwei = new User("job4jM", 200, new GregorianCalendar(2021, 10, 29));

        Map<User, Object> userMap = new HashMap<>();
        userMap.put(ein, new Object());
        userMap.put(zwei, new Object());

        for (User k : userMap.keySet()) {
            Object value = userMap.get(k);
            System.out.println("key: " + k + " and value: " + value);
        }
    }
}
