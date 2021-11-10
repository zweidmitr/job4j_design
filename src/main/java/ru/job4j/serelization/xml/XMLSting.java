package ru.job4j.serelization.xml;

import ru.job4j.serelization.Job4j;
import ru.job4j.serelization.Target;

public class XMLSting {
    public static void main(String[] args) {
        int[] courseSteps = new int[]{1, 2, 3};
        final Job4j myCourse = new Job4j("https://job4j.ru/");
        final Target target = new Target("java work", true, 141, courseSteps, myCourse);


    }
}
