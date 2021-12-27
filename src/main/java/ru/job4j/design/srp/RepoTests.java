package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RepoTests {
    public static void main(String[] args) {
        jsonTest();
        System.out.println("=====");
        xmlTest();
        System.out.println("done");

        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+03:00");
        now = Calendar.getInstance();
        System.out.println(now);
        System.out.println(formatter.format(now.getTime()));

    }

     public static void jsonTest() {
         MemStore store = new MemStore();
         Calendar now = Calendar.getInstance();
         Employee worker = new Employee("Ivan", now, now, 100);
         store.add(worker);
         Report engine = new ReportToJSON(store);
         System.out.println(engine.generate(em -> true));
     }

     public static void xmlTest() {
         MemStore store = new MemStore();
         Calendar now = Calendar.getInstance();
         Employee worker = new Employee("Ivan", now, now, 100);
         store.add(worker);
         Report engine = new ReportToXML(store);
         System.out.println(engine.generate(em -> true));
     }
}
