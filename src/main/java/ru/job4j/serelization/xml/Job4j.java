package ru.job4j.serelization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "myBestCourse")
public class Job4j {
    @XmlAttribute
    private String courseName;

    public Job4j() {

    }

    public Job4j(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Job4j{"
                + "courseName='" + courseName + '\''
                + '}';
    }
}
