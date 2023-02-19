package commands;

import dataBase.GlobalObj;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandHandler {

    private static Map<String, BaseCommand> map;

    static {
        map = new LinkedHashMap<>();

        map.put("add", new AddToCollection());
        map.put("info", new Info());
        map.put("show", new Show());
        map.put("clear", new Clear());
        map.put("save", new Save());
        map.put("exit", new Exit());
        map.put("remove_by_id", new Remove_by_id());
        map.put("help", new Help());
    }

    public static void handleCommand(String str) {
        var a = str.split(" ");
        try {
            if (a.length > 1) {
                map.get(a[0]).setParameter(a[1]);
            }
            map.get(a[0]).execute(GlobalObj.dataBase);
        } catch (Exception e) {
            System.out.println("you entered an invalid command, type help to see a list of available commands and their description");
        }
    }
}
