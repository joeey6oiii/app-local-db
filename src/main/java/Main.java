import commands.CommandManager;
import commands.Remove_by_id;
import dataBase.DataBase;
import dataBase.GlobalObj;
import dataBase.Loader;
import defaultClasses.*;
import generators.PersonGenerator;
import yamlsTools.*;


import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Loader loader = new Loader();
        loader.assertToken();
        Class<Person> type = Person.class;
        String path = "Person.yaml";
        YamlReader yamlReader = new YamlReader();
        List<Person> list = null;
        try {
            list = yamlReader.readYaml(path, type);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert list != null;
        DataBase dataBase = new DataBase();
        loader.load(dataBase, list);
        System.out.println(dataBase.getCollection());
        CommandManager commandManager = new CommandManager();
        commandManager.startWorking();

    }
}
