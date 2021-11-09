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
        boolean temp = true;
        while (!OUT.equals(marker)) {
            if (temp) {
                System.out.println(getRandom());
            }
            answer = scanner.nextLine();
            check(answer);
            if (STOP.equals(marker)) {
                temp = false;
            }
            if (CONTINUE.equals(marker)) {
                temp = true;
            }
        }
        saveLog(log);
    }

    private void check(String answer) {
        log.add(answer);
        if (OUT.equals(answer)) {
            marker = OUT;
        } else if (CONTINUE.equals(answer)) {
            marker = CONTINUE;
        } else if (STOP.equals(answer)) {
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
        ConsoleChat cc = new ConsoleChat("./src/data/text.txt",
                "./src/data/log.txt");
        cc.run();
    }
}
