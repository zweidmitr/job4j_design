package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        checkArgs(argsName.getArgs());
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");

        checkPath(path);
        Path filePath = Paths.get(path);
        String[] filter = argsName.get("filter").split(",");

        String header = String.join(delimiter, filter);
        StringBuilder builder = new StringBuilder();
        builder.append(header).append(System.lineSeparator());
        try (Scanner scanner = new Scanner(filePath)) {
            builder = parsing(scanner, builder, filter, delimiter);
        }
        print(out, builder);
    }

    private static void print(String out, StringBuilder builder) throws IOException {
        if (out.equals("stdout")) {
            System.out.print(builder);
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(out))) {
                writer.print(builder);
            }
        }
    }

    private static StringBuilder parsing(Scanner scanner, StringBuilder builder, String[] filter, String delimiter) {
        List<String> columns = Arrays.asList(scanner.nextLine().split(delimiter));
        int[] indexes = new int[filter.length];
        for (int i = 0; i < filter.length; i++) {
            int index = columns.indexOf(filter[i]);
            if (index == -1) {
                throw new NoSuchElementException("filter is not correct");
            }
            indexes[i] = index;
        }
        String[] strings = new String[indexes.length];
        while (scanner.hasNextLine()) {
            String[] nextLine = scanner.nextLine().split(delimiter);
            for (int i = 0; i < indexes.length; i++) {
                strings[i] = nextLine[indexes[i]];
            }
            String result = String.join(delimiter, strings);
            builder.append(result).append(System.lineSeparator());
        }
        return builder;
    }

    private static void checkArgs(String[] args) {
        for (String s : args) {
            if (!s.contains("-path") && !s.contains("-delimiter") && !s.contains("-out") && !s.contains("-filter")) {
                throw new IllegalArgumentException("check String[] args");
            }
        }
    }

    private static void checkPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("ALARM, not exist, check path!");
        }
    }
}
