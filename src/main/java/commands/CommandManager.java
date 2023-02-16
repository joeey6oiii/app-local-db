package commands;

import dataBase.DataBase;
import dataBase.GlobalObj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class CommandManager {
    private Map<String, CommandExecuteInterface> map;
    public CommandManager(){
        map = new HashMap<>();
        AddToCollection addToCollection = new AddToCollection();
        CommandExecuteInterface add = addToCollection::execute;
        map.put("add", add);

    }

    public void startWorking(){
        System.out.println("CommandManager stated");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while(str!="exit") {
            var a = str.split(" ");
            map.get(a[0]).execute(GlobalObj.dataBase);
            str = scanner.nextLine();
        }
    }

}
