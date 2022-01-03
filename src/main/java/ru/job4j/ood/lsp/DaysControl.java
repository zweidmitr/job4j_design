package ru.job4j.ood.lsp;

/**
 * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 * Принцип подстановки Лисков. - пример нарушения, когда наследуемый класс
 * меняет постусловия
 */
class Student {
    protected int dayCountTasks;
    protected boolean goodDay = true;

    public Student(int dayCountTasks) {
        this.dayCountTasks = dayCountTasks;
    }

    public void check() {
        if (dayCountTasks < 4) {
            throw new IllegalArgumentException("Student didn't work enough!");
        }
        System.out.println("day passed");
    }
}

class JavaStudent extends Student {
    public JavaStudent(int dayCountTasks) {
        super(dayCountTasks);
    }

    @Override
    public void check() {
        System.out.println("day passed");
    }
}

public class DaysControl {
    public static void main(String[] args) {
        Student normStudent = new Student(3);
        Student javaStudent = new JavaStudent(3);
        normStudent.check();
        javaStudent.check();
    }
}
