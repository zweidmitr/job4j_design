package ru.job4j.io.scanner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ScannerExample3 {
    public static void main(String[] args) throws Exception {
        var data = "A 1B FF 110";
        var file = File.createTempFile("data", null);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(data.getBytes());
        }

        /**
         * Метод useRadix() указывает в какой системе счисления находятся входные числа
         */
        try (var scanner = new Scanner(file).useRadix(16)) {
            while (scanner.hasNext()) {
                System.out.print(scanner.nextInt());
                System.out.print(" ");
            }
        }
    }
}
