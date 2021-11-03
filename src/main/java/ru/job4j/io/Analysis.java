package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {

        String[] array;
        String line;
        boolean mark = false;
        String startTime = "";
        String finishTime = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            while ((line = reader.readLine()) != null) {

                array = line.split(" ");
                String status = array[0];
                String time = array[1];
                if (status.equals("400") || status.equals("500")) {
                    mark = true;
                    startTime = time;
                }
                if (mark && status.equals("200") || status.equals("300")) {
                    mark = false;
                    finishTime = time;
                    writer.println(startTime + ";" + finishTime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");

            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String source = "unavailable.csv";
        String target = "result.txt";

        Analysis analysis = new Analysis();
        analysis.unavailable(source, target);

    }
}
