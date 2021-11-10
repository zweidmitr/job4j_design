package ru.job4j.io.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Dmitrii Zwei";
        int age = 30;

        byte apartmentNumber = 0;
        short homeNumber = 1;
        int index = 999999;
        long phoneNumber = 8_911_777_7777L;

        float fTemp = 36F;
        double temp = 0.1;
        char abracadabra = 'u';
        boolean isItMagic = false;

        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("my apartmentNumber = {}, and hoeNumber is {}.", apartmentNumber, homeNumber, phoneNumber);
        LOG.debug("and your phone is {}, i always forget index {}", phoneNumber, index);
        LOG.debug("temp on PC show {}, but thermometer show {}", fTemp, temp);
        LOG.debug("is it magic? {} you say {}...", isItMagic, abracadabra);

        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
