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
        Class<Person[]> type = Person[].class;
        String path = "Person.yaml";
        YamlReader yamlReader = new YamlReader();
        Person[] arr = null;
        try {
            arr = yamlReader.readYaml(path, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Loader loader = new Loader();
        assert arr != null;
        loader.load(GlobalObj.dataBase, arr);
        System.out.println(Arrays.toString(GlobalObj.dataBase.getCollection().toArray()));
        PersonGenerator personGenerator = new PersonGenerator();
        personGenerator.generate();
        CommandManager commandManager = new CommandManager();
        commandManager.startWorking();

    }
}
