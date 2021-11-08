package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader writer = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            writer.lines().forEach(b -> builder.append(b + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            data.forEach(elem -> writer.println(elem));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./src/data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        encoding.writeDataInFile(path, strings);
        String s = encoding.readFile(path);
        System.out.println("Данные из файла");
        System.out.println(s);
    }
}
