import commands.*;
import dataBase.*;
import defaultClasses.*;
import yamlsTools.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u001B[33m" + "---Welcome to the Person" +
                " database console application!---" + "\u001B[0m");
        Loader loader = new Loader();
        loader.assertToken();
        Class<Person> type = Person.class;
        String path = "Person.yaml";
        YamlReader yamlReader = new YamlReader();
        List<Person> list = null;
        try {
            list = yamlReader.readYaml(path, type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert list != null;
        loader.load(GlobalObj.dataBase, list);
        CommandManager commandManager = new CommandManager();
        commandManager.startWorking();

    }
}
