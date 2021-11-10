package ru.job4j.serelization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serelization.Job4j;
import ru.job4j.serelization.Target;

public class JSONString {
    public static void main(String[] args) {
        int[] courseSteps = new int[]{1, 2, 3};
        final Job4j myCourse = new Job4j("https://job4j.ru/");
        final Target target = new Target("java work", true, 141, courseSteps, myCourse);

        /**
         * преобразуем объект target в json стопку
         */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(target));

        /**
         * модифициуем json стопку
         */

        final String targetJson =
                "{"
                        + "\"desire\":true,"
                        + "\"name\":javaWork!!,"
                        + "\"daysCount\": 134,"
                        + "\"courseName\":"
                        + "{"
                        + "\"courseName\":\"https://job4j.ru/profile\""
                        + "},"
                        + "\"courseSteps\":"
                        + "[\"2\",\"3\"]"
                        + "}";
        final Target targetMod = gson.fromJson(targetJson, Target.class);
        System.out.println(targetMod);
    }

}
