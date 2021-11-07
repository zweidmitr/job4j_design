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

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        packSingleFile(new File("./pom.xml"), new File("./pom.zip"));
        ArgsName keys = ArgsName.of(args);
        if (keys.getSize() != 3) {
            throw new IllegalArgumentException("check argument size");
        }
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

    private static boolean checkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory: %s", file.getAbsoluteFile()));
        }
        return true;
    }
}
