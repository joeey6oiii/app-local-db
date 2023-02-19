package commands;

import dataBase.DataBase;

public class Show extends BaseCommand {
    public void execute(DataBase obj) {
        if (obj.getCollection().size() == 0)
            System.out.println("Collection is empty");
        for (var a : obj.getCollection()) {
            System.out.println(a.toString());
        }
    }

    public void describe() {
        System.out.println("Prints to standard output all elements of the collection in string representation");
    }
}
