package commands;

import dataBase.GlobalObj;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Command processing class
 *
 * @authors Dmitrii Chebanenko and Alexey
 */
public class CommandHandler {
    /**
     * Field to store all commands
     */
    private static Map<String, BaseCommand> map;
    /**
     * Field for storing executed commands
     */
    private static ArrayList<String> history;

    /**
     *
     The map initialization block, if you add a command, you must add it to the map
     */
    static {
        map = new LinkedHashMap<>();
        history = new ArrayList<>();
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
        map.put("execute_script", new ExecuteScript());
        map.put("remove_greater", new RemoveGreater());
        map.put("remove_lower", new RemoveLower());
    }

    /**
     * Method for processing commands with CommandHandler or with ExecuteScript
     *
     * @param str - command from CommandHandler or from ExecuteScript
     */

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

    /**
     * Method for getting a list containing available commands
     *
     * @return returns a list of commands
     */
    public static Map<String, BaseCommand> getMap() {
        return map;
    }

    /**
     * Method for getting command execution history
     *
     * @return returns history of used commands
     */
    public static ArrayList<String> getHistory() {
        return history;
    }

    /**
     * A method that is used to get the command name (key) by a value from the collection.
     *
     * @param map the collection where all the commands are stored
     * @param value a value of an object in the collection
     * @return null if collection contains no key for the specified value, returns key otherwise
     * @param <K> arbitrary non-primitive data type
     * @param <V> arbitrary non-primitive data type
     */

    private static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * A method that counts the length of each command name and returns name of the longest one. Used for the {@link Help} command.
     *
     * @return name of the longest command in the collection
     */

    public static String getLongestCommandName() {
        String command = "";
        for (Map.Entry<String, BaseCommand> entry : map.entrySet()) {
            if (entry.getKey().length() > command.length()) {
                command = entry.getKey();
            }
        }
        return command;
    }
}