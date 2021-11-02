package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class LogFilter {
    public static void main(String[] args) {
        String strings = filter();
        System.out.println(strings);
    }

    public static String filter() {
        String result = "";
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.contains("404")) {
                    result = result + System.lineSeparator() + line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
