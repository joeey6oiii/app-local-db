package commands;

import dataBase.DataBase;

public class Info extends BaseCommand {
    public void execute(DataBase obj) {
        System.out.println("Type: " + obj.getTypeOfTheCollection());
        System.out.println("Length: " + obj.getSizeOfTheCollection());
        System.out.println("Initialization Time: " + obj.getInitializationTime());
    }

    public void describe() {
        System.out.println("Print information about the collection to the standard output stream (type, initialization date, number of elements, etc.)");
    }
}
