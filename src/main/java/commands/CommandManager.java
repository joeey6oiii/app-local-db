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
        Info info = new Info();
        CommandExecuteInterface add = addToCollection::execute;
        CommandExecuteInterface informationAboutCollection = info::execute;
        map.put("add", add);
        map.put("info", informationAboutCollection);

    }

    public void startWorking(){
        System.out.println("CommandManager stated");
        Scanner scanner = new Scanner(System.in);
        System.out.print("$ ");
        String str = scanner.nextLine();
        while(str!="exit") {
            var a = str.split(" ");
            map.get(a[0]).execute(GlobalObj.dataBase);
            System.out.print("$ ");
            str = scanner.nextLine();
        }
    }

}
