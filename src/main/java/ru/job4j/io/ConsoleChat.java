package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private String marker = CONTINUE;
    private List<String> log = new ArrayList<>();
    List<String> baseOfPhrases;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        baseOfPhrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        check(answer);
        while (marker.equals("продолжить")) {
            check(answer);
            if (marker.equals("закончить")) {
                break;
            }
            while (!marker.equals("стоп") || !marker.equals("закончить")) {

                if (marker.equals("стоп") || marker.equals("закончить")) {
                    break;
                }
                System.out.println(getRandom());
                answer = scanner.nextLine();
                check(answer);
            }
            while (!marker.equals("продолжить") || !answer.equals("закончить")) {
                answer = scanner.nextLine();
                check(answer);
                if (answer.equals("продолжить") || answer.equals("закончить")) {
                    break;
                }
            }
        }
        saveLog(log);
    }

    private void check(String answer) {
        log.add(answer);
        if (answer.equals("закончить")) {
            marker = OUT;
        } else if (answer.equals("продолжить")) {
            marker = CONTINUE;
        } else if (answer.equals("стоп")) {
            marker = STOP;
        }
    }

    private String getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(baseOfPhrases.size());
        String result = baseOfPhrases.get(randomIndex);
        log.add(result);
        return result;
    }

    private List<String> readPhrases() {
        List<String> baseOfPhrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(phrase -> baseOfPhrases.add(phrase));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseOfPhrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(botAnswers))) {
            log.forEach(line -> writer.println(line));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\src\\data\\text.txt",
                "C:\\projects\\job4j_design\\src\\data\\log.txt");
        cc.run();
    }
}
