package ru.job4j.serelization;

public class Job4j {
    private String courseName;

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
