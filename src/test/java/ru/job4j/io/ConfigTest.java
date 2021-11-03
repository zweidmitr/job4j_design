package ru.job4j.io;


import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\projects\\job4j_design\\pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitrii"));
        assertThat(config.value("surname"), is("Zwei"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "C:\\projects\\job4j_design\\pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitrii"));
        assertThat(config.value("surname"), is("Zwei"));
    }
}