package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String line;
            String name = "";
            String surname = "";
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s+", "");
                if (line.startsWith("name")) {
                    name = line.substring(5, line.length());
                    values.put("name", name);
                } else if (line.startsWith("surname")) {
                    surname = line.substring(8, line.length());
                    values.put("surname", surname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
