import commands.*;
import dataBase.*;
import defaultClasses.*;
import yamlsTools.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u001B[33m---Welcome to the Person" +
                " database console application---\u001B[0m");
        System.out.print("\nInput path to the file\n$ ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine(); // src/main/resources/Person.yaml
        Loader loader = new Loader();
        loader.assertToken();
        Class<Person> type = Person.class;
        YamlReader yamlReader = new YamlReader();
        List<Person> list = new ArrayList<>();
        try {
            list = yamlReader.readYaml(path, type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loader.load(GlobalObj.dataBase, list);
        CommandManager commandManager = new CommandManager();
        commandManager.startWorking();
    }
}