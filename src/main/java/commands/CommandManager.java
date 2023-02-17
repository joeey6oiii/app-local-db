package commands;

import dataBase.DataBase;
import dataBase.GlobalObj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    private Map<String, BaseCommand> map;

    public CommandManager() {
        map = new LinkedHashMap<>();


        map.put("add", new AddToCollection());
        map.put("info", new Info());
        map.put("show", new Show());
        map.put("clear", new Clear());
        map.put("save", new Save());
        map.put("exit", new Exit());
    }

    public void startWorking() {
        System.out.println("CommandManager stated");
        Scanner scanner = new Scanner(System.in);
        System.out.print("$ ");
        String str = scanner.nextLine();
        while (true) {
            var a = str.split(" ");
            try {
                map.get(a[0]).execute(GlobalObj.dataBase);
            } catch (Exception e) {
                System.out.println("you entered an invalid command, type help to see a list of available commands and their description");
            }
            System.out.print("$ ");
            str = scanner.nextLine();
        }
    }

}
