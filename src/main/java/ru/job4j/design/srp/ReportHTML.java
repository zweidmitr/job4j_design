package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportHTML implements Report {

    private Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta content=\"...\" />")
                .append(System.lineSeparator())
                .append("<title> Name; Hired; Fired; Salary; </title>")
                .append("<head>")
                .append(System.lineSeparator())
                .append("<body>");

        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator())
                    .append("</body>")
                    .append("</html>");
        }
        return text.toString();
    }
}
