package ru.job4j.serelization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Target {
    private final String name;
    private final boolean desire;
    private final int daysCount;

    public Target(String name, boolean desire, int daysCount) {
        this.name = name;
        this.desire = desire;
        this.daysCount = daysCount;
    }

    @Override
    public String toString() {
        return "Target{"
                + "name='" + name + '\''
                + ", desire=" + desire
                + ", daysCount=" + daysCount
                + '}';
    }

    public static void main(String[] args) {
        final Target target = new Target("java work", true, 141);

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
                        + "\"name\":javaWork,"
                        + "\"daysCount\": 191"
                        + "}";
        final Target targetMod = gson.fromJson(targetJson, Target.class);
        System.out.println(targetMod);
    }
}
