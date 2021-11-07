package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("check arguments.");
        }
        File file = new File(args[0]);

        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("not exist or not directory, check path");
        }

        Path start = Paths.get(args[0]);
        String tempS = args[1];
        search(start, p -> p.toFile().getName().endsWith(tempS)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
