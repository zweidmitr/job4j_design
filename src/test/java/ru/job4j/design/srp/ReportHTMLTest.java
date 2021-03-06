package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHTMLTest {

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta content=\"...\" />")
                .append(System.lineSeparator())
                .append("<title> Name; Hired; Fired; Salary; </title>")
                .append("<head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator())
                .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}