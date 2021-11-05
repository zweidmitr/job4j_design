package ru.job4j.io;


import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitrii"));
        assertThat(config.value("surname"), is("Zwei"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitrii"));
        assertThat(config.value("surname"), is("Zwei"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenAlarmTest() {
        String path = "./data/pair_with_alarm.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenEmptyLine() {
        String path = "./data/pair_with_empty_line.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitrii"));
        assertThat(config.value("surname"), is("Zwei"));
    }
}