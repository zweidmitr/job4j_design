package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        boolean tempBug = false;
        if (args.length == 0) {
            throw new IllegalArgumentException("alarm");
        }
        for (String element : args) {
            if (!element.contains("=")) {
                tempBug = true;
                break;
            }
            String[] tempArray = element.split("=");
            if (tempArray.length != 2) {
                tempBug = true;
                break;
            }
            if (tempArray[0] == null || tempArray[1] == null) {
                tempBug = true;
                break;
            }
            String key = tempArray[0];
            if (key.startsWith("-")) {
                key = key.substring(1);
            }
            String value = tempArray[1];
            values.put(key, value);
        }

        if (tempBug) {
            throw new IllegalArgumentException("alarm");
        }

    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
