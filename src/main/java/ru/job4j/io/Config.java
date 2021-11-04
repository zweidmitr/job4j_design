package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        boolean tempBug = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String line;
            String name = "";
            String surname = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains("#") || line.length() == 0) {
                    continue;
                }
                line = line.replaceAll("\\s+", "");
                if (line.startsWith("name")) {
                    name = line.substring(5);
                    values.put("name", name);
                } else if (line.startsWith("surname")) {
                    surname = line.substring(8);
                    values.put("surname", surname);
                } else {
                    tempBug = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tempBug) {
            throw new IllegalArgumentException("alarm");
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(s -> out.add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
