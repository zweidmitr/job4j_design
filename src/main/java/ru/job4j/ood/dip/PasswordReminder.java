package ru.job4j.ood.dip;

/**
 * Примеры нарушение DIP - зависимость от класса Connection, лучше реализовать через интерфейс
 */
public class PasswordReminder {
    private Connection connect;

    public void context(Connection tamParam) {
        this.connect = tamParam;
    }
}

class Connection {
}

