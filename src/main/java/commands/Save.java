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
            System.out.println("Something went wrong, the file was not created");
        }
        System.out.println("Your collection has been saved. Your file is on the path \"src/main/resources/orderOutput.yaml\"");
    }

    public void describe() {
        System.out.println("This command save collection to file");
    }
}
