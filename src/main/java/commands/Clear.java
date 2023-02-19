package commands;

import dataBase.DataBase;

import java.util.Iterator;

public class Clear extends BaseCommand {
    public void execute(DataBase obj) {
        Iterator i = obj.getCollection().iterator();
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
        System.out.println("Collection has been cleared");
    }

    public void describe() {
        System.out.println("This command clears the collection");
    }
}
