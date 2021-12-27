package ru.job4j.design.srp;

import java.util.Calendar;

public class RepoTests {
    public static void main(String[] args) {
        JSONTest();
        System.out.println("=====");
        XMLTest();
        System.out.println("done");

    }
     public static void JSONTest() {
         MemStore store = new MemStore();
         Calendar now = Calendar.getInstance();
         Employee worker = new Employee("Ivan", now, now, 100);
         store.add(worker);
         Report engine = new ReportToJSON(store);
         System.out.println(engine.generate(em -> true));
     }

     public static void XMLTest() {
         MemStore store = new MemStore();
         Calendar now = Calendar.getInstance();
         Employee worker = new Employee("Ivan", now, now, 100);
         store.add(worker);
         Report engine = new ReportToXML(store);
         System.out.println(engine.generate(em -> true));
     }
}
