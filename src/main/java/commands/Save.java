package commands;

import dataBase.DataBase;
import yamlsTools.YamlWriter;

import java.io.IOException;

public class Save extends BaseCommand {
    public void execute(DataBase obj) {
        YamlWriter yamlWriter = new YamlWriter();
        try {
            yamlWriter.writeYaml(obj.getCollection());
        } catch (IOException e) {
            System.out.println("Something went wrong, the file was not created, please, try again");
        }
        System.out.println("The collection has been saved. The path to the file is: \"src/main/resources/orderOutput.yaml\"");
    }

    public void describe() {
        System.out.println("Saves the collection to a file");
    }
}
