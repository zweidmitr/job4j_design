package ru.job4j.design.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportToXMLTest {

    @Test
    public void whenXMLTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+03:00");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToXML(store);
        StringBuilder result = new StringBuilder();
        result
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<users>\n")
                .append("    <users>\n")
                .append("        <fired>" + formatter.format(now.getTime()) + "</fired>\n")
                .append("        <hired>" + formatter.format(now.getTime()) + "</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100.0</salary>\n")
                .append("    </users>\n")
                .append("</users>\n");
        assertThat(engine.generate(em -> true), is(result.toString()));

    }

}