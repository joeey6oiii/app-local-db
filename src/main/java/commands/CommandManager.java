package commands;

import dataBase.DataBase;
import dataBase.GlobalObj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    public void startWorking() {
        System.out.println("CommandManager stated");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String str = scanner.nextLine();
            CommandHandler.handleCommand(str);
        }
    }

}
