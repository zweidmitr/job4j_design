package ru.job4j.ood.dip;

/**
 * Примеры нарушение DIP - лучше использовать интерфейс для book и DVD
 */
public class Shelf {
    Book book;

    void addBook(Book book) {
    }

    void customizeShelf() {
    }
}

class DVD {
    void seeReviews() {
    }

    void watchSample() {
    }
}

class Book {
    void seeReviews() {
    }

    void readSample() {
    }
}
