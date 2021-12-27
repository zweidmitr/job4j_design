package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportToJSON implements Report {
    private Store store;

    public ReportToJSON(Store store) {
        this.store = store;
    }

    /**
     * преобразуем объект store в json стопку
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store);
    }
}
