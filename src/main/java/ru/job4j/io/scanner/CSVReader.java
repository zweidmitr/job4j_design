package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVReader {

    public static void main(String[] args) throws Exception {
        var path = "C:\\projects\\job4j_design\\src\\data\\csvTest.csv";
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + path, "-delimiter=;", "-out=" + "stdout", "-filter=Внешний идентификатор для импорта,Название"});
        handle(argsName);
    }

    public static void handle(ArgsName argsName) throws Exception {
        checkArgs(argsName.getArgs());
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");

        checkPath(path);
        Path filePath = Paths.get(path);
        String[] filter = argsName.get("filter").split(",");

        String header = String.join(delimiter, filter);
        String ls = System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        builder.append(header).append(ls);
        try (Scanner scanner = new Scanner(filePath)) {
            String firstLine = scanner.nextLine();
            List<String> columns = Arrays.asList(firstLine.split(delimiter));
            int[] indexes = new int[filter.length];
            for (int i = 0; i < filter.length; i++) {
                int index = columns.indexOf(filter[i]);
                if (index == -1) {
                    throw new NoSuchElementException("filter is not correct");
                }
                indexes[i] = index;
            }
            String[] strings = new String[indexes.length];
            String result;
            while (scanner.hasNextLine()) {
                String[] nextLine = scanner.nextLine().split(delimiter);
                for (int i = 0; i < indexes.length; i++) {
                    strings[i] = nextLine[indexes[i]];
                }
                result = String.join(delimiter, strings);
                builder.append(result).append(ls);
            }
        }
        if (out.equals("stdout")) {
            System.out.print(builder);
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(out))) {
                writer.print(builder);
            }
        }
    }

    private static boolean checkArgs(String[] args) {
        boolean result = false;
        for (String s : args) {
            if (s.contains("-path") || s.contains("-delimiter") || s.contains("-out") || s.contains("-filter")) {
                result = true;
            } else {
                throw new IllegalArgumentException("check String[] args");
            }
        }
        return result;
    }

    private static void checkPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("ALARM, not exist, check path!");
        }
    }
}
