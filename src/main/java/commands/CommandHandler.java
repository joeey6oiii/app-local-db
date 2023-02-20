package commands;

import dataBase.GlobalObj;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandHandler {

    private static Map<String, BaseCommand> map;
    private static ArrayList<String> history = new ArrayList<>();

    static {
        map = new LinkedHashMap<>();

        map.put("add", new AddToCollection());
        map.put("info", new Info());
        map.put("show", new Show());
        map.put("clear", new Clear());
        map.put("save", new Save());
        map.put("exit", new Exit());
        map.put("remove_by_id", new RemoveById());
        map.put("help", new Help());
        map.put("update", new UpdateById());
        map.put("history", new CommandHistory());
        map.put("sum_of_height", new SumOfHeight());
        map.put("average_of_height", new AverageOfHeight());
        map.put("print_field_descending_birthday", new PrintFieldDescendingBirthday());
    }

    public static void handleCommand(String str) {
        var a = str.split(" ");
        try {
            if (a.length > 1) {
                map.get(a[0]).setParameter(a[1]);
            }
            map.get(a[0]).execute(GlobalObj.dataBase);
            history.add(CommandHandler.getKey(map, map.get(a[0])));
        } catch (Exception e) {
            System.out.println("Invalid command. Please, type \"help\" to see a list of available commands and their description");
        }
    }

    public static Map<String, BaseCommand> getMap(){
        return map;
    }

    public static ArrayList<String> getHistory() {
        return history;
    }

    private static  <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Integer getLongestCommand() {
        int length = 4;
        for (Map.Entry<String, BaseCommand> entry : map.entrySet()) {
            if (entry.getKey().length() > length) {
                length = entry.getKey().length() + 4;
            }
        }
        return length;
    }
}