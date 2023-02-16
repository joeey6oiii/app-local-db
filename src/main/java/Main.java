import defaultClasses.*;
import generators.Generate;
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
        DataBase<Person> dataBase = new DataBase<>();
        Loader loader = new Loader();
        assert arr != null;
        loader.load(dataBase, arr);
        System.out.println(Arrays.toString(dataBase.getCollection().toArray()));
        PersonGenerator personGenerator = new PersonGenerator();
        personGenerator.generate();
    }
}
