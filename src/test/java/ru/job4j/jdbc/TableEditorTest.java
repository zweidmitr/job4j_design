package ru.job4j.jdbc;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TableEditorTest {

    @Test
    public void whenCreateTable() {
        try (FileInputStream file = new FileInputStream("app.properties")) {
            Properties proper = new Properties();
            proper.load(file);

            TableEditor tableEditor = new TableEditor(proper);
            tableEditor.createTable("test");
            tableEditor.close();
            System.out.println("create");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDropTable() {
        try (FileInputStream file = new FileInputStream("app.properties")) {
            Properties proper = new Properties();
            proper.load(file);

            TableEditor tableEditor = new TableEditor(proper);
            tableEditor.dropTable("test");
            tableEditor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenADDCOLUMN() {
        try (FileInputStream file = new FileInputStream("app.properties")) {
            Properties proper = new Properties();
            proper.load(file);

            TableEditor tableEditor = new TableEditor(proper);
            tableEditor.addColumn("test", "bars", "varchar(255)");
            tableEditor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDROPCOLUMN() {
        try (FileInputStream file = new FileInputStream("app.properties")) {
            Properties proper = new Properties();
            proper.load(file);

            TableEditor tableEditor = new TableEditor(proper);
            tableEditor.dropColumn("test", "bars");
            tableEditor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenRENAMECOLUMN() {
        try (FileInputStream file = new FileInputStream("app.properties")) {
            Properties proper = new Properties();
            proper.load(file);

            TableEditor tableEditor = new TableEditor(proper);
            tableEditor.renameColumn("test", "bars", "horizon");
            tableEditor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}