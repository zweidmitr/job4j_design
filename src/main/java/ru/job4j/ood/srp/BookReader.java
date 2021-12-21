package ru.job4j.ood.srp;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * реализация нарушения SRP
 * - метод books читает данные из файла
 * - метод send создает объекты
 */
public class BookReader implements Reader {
    @Override
    public List books(String names) {
        Properties config = new Properties();
        try (InputStream in = BookReader
                .class.getClassLoader().getResourceAsStream("books.properties")) {
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void send(List openBooks) {
        Book b1 = new Book("Brave new world", "Aldous Huxley");
        Book b2 = new Book("Brave New World Revisited", "Aldous Huxley");
    }
}
