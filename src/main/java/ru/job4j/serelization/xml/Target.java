package ru.job4j.serelization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "myTarget")
@XmlAccessorType(XmlAccessType.FIELD)
public class Target {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean desire;
    private int daysCount;
    @XmlElementWrapper
    @XmlElement(name = "step")
    private int[] courseSteps;
    private Job4j courseName;

    public Target() {

    }

    public Target(String name, boolean desire, int daysCount, Job4j courseName, int... courseSteps) {
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
