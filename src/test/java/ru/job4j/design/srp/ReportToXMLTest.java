package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportToXMLTest {

    @Test
    public void whenXMLTest() throws DatatypeConfigurationException {
        MemStore store = new MemStore();
        Calendar now = GregorianCalendar.getInstance();
        now.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        XMLGregorianCalendar proba = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToXML(store);
        StringBuilder result = new StringBuilder();
        result
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<users>\n")
                .append("    <users>\n")
                .append("        <fired>" + proba + "</fired>\n")
                .append("        <hired>" + proba + "</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100.0</salary>\n")
                .append("    </users>\n")
                .append("</users>\n");
        assertThat(engine.generate(em -> true), is(result.toString()));

    }

}