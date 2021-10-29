package ru.job4j.test;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    public static void main(String[] args) {
        User ein = new User("job4jM", 200, new GregorianCalendar(2021, 10, 29));
        User zwei = new User("job4jM", 200, new GregorianCalendar(2021, 10, 29));

        Map<User, Object> userMap = new HashMap<>();
        userMap.put(ein, new Object());
        userMap.put(zwei, new Object());

        for (User k : userMap.keySet()) {
            int h = 0;
            Object value = userMap.get(k);
            System.out.println("key: " + k + " and value: " + value);
            System.out.println(k.hashCode());
            h = k.hashCode() ^ (h >>> 16);
            System.out.println("hash: " + h);
        }
    }
}
