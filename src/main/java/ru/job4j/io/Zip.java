package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        checkArgs(args);
        ArgsName keys = ArgsName.of(args);
        checkSize(keys, 3);

        String directory = keys.get("d");
        String exclude = keys.get("e");
        String output = keys.get("o");
        checkDir(directory);

        List dirList = Search.search(Path.of(directory), path -> !path.toFile()
                .getName().endsWith(exclude))
                .stream().map(Path -> Path.toFile())
                .collect(Collectors.toList());

        packFiles(dirList, new File(output));
    }

    private static void checkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory: %s", file.getAbsoluteFile()));
        }
    }

    private static void checkSize(ArgsName keys, int count) {
        if (keys.getSize() != count) {
            throw new IllegalArgumentException("check argument size");
        }
    }

    private static boolean checkArgs(String[] args) {
        boolean result = false;
        for (String s : args) {
            if (s.contains("-d") || s.contains("-e") || s.contains("-o")) {
                result = true;
            } else {
                throw new IllegalArgumentException("check String[] args");
            }
        }
        return result;
    }
}
