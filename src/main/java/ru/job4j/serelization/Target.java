package ru.job4j.serelization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Target {
    private final String name;
    private final boolean desire;
    private final int daysCount;
    private final int[] courseSteps;
    private final Job4j courseName;

    public Target(String name, boolean desire, int daysCount, int[] courseSteps, Job4j courseName) {
        this.name = name;
        this.desire = desire;
        this.daysCount = daysCount;
        this.courseSteps = courseSteps;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Target{"
                + "name='" + name + '\''
                + ", desire=" + desire
                + ", daysCount=" + daysCount
                + ", courseSteps=" + Arrays.toString(courseSteps)
                + ", courseName=" + courseName
                + '}';
    }
}
