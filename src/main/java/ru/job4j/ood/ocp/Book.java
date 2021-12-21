package ru.job4j.ood.ocp;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * пример нарушения принципа OCP
 * - на создаваемые объекты
 * - на параметры и возвращаемые типы методы
 */
public class Book {
    private String name;
    private String authorName;

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public List books(String names) {
        Properties config = new Properties();
        try (InputStream in = ru.job4j.ood.srp.BookReader
                .class.getClassLoader().getResourceAsStream("books.properties")) {
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String loadBook() {
        return "book is loading";
    }

    public String downloadBook() {
        return "book is download";
    }

    public void delete(String nameBook) {
        String method = "remove algorithm";
    }

    public class BookJournal {
        private Book book;

        public void deleteJournal(String nameJournal) {
            book.delete(nameJournal);
        }
    }
}
