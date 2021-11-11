package ru.job4j.serelization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLMarshal {
    public static void main(String[] args) throws Exception {
        Target myTarget =
                new Target("way", true, 100,
                        new Job4j("job4j.ru/profile"), 2, 3);
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Target.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(myTarget, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Target result = (Target) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
