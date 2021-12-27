package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportToJSONTest {

    @Test
    public void whenJSONTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToJSON(store);
        String expected = "{\"employees\":[{\"name\":\"Ivan\",\"hired\":{\"year\":"
                + now.get(Calendar.YEAR) + ",\"month\":"
                + now.get(Calendar.MONTH) + ",\"dayOfMonth\":"
                + now.get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":"
                + now.get(Calendar.HOUR_OF_DAY) + ",\"minute\":"
                + now.get(Calendar.MINUTE) + ",\"second\":"
                + now.get(Calendar.SECOND) + "},\"fired\":{\"year\":"
                + now.get(Calendar.YEAR) + ",\"month\":"
                + now.get(Calendar.MONTH) + ",\"dayOfMonth\":"
                + now.get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":"
                + now.get(Calendar.HOUR_OF_DAY) + ",\"minute\":"
                + now.get(Calendar.MINUTE) + ",\"second\":"
                + now.get(Calendar.SECOND) + "},\"salary\":100.0}]}";
        assertThat(engine.generate(em -> true), is(expected));
    }
}