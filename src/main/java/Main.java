import defaultClasses.*;
import yamlsTools.*;


import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Class<Person[]> type = Person[].class;
        String path = "Person.yaml";
        YamlReader yamlReader = new YamlReader();
        try {
            System.out.println(Arrays.toString(yamlReader.
                    readYaml(path, type)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
