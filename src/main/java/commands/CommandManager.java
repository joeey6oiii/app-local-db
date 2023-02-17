package commands;

import dataBase.DataBase;
import dataBase.GlobalObj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    private Map<String, CommandExecuteInterface> map;

    public CommandManager() {
        map = new HashMap<>();
        AddToCollection addToCollection = new AddToCollection();
        Info info = new Info();
        Show show = new Show();
        Clear clear = new Clear();
        Save save = new Save();
        Exit exit = new Exit();
        CommandExecuteInterface add = addToCollection::execute;
        CommandExecuteInterface informationAboutCollection = info::execute;
        CommandExecuteInterface showCollection = show::execute;
        CommandExecuteInterface clearCollection = clear::execute;
        CommandExecuteInterface saveCollection = save::execute;
        CommandExecuteInterface exitCollection = exit::execute;
        map.put("add", add);
        map.put("info", informationAboutCollection);
        map.put("show", showCollection);
        map.put("clear", clearCollection);
        map.put("save", saveCollection);
        map.put("exit", exitCollection);
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
