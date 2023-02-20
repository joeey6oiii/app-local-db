package commands;

import java.util.Scanner;

public class CommandManager {
    public void startWorking() {
        System.out.println("CommandManager started");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String str = scanner.nextLine();
            CommandHandler.handleCommand(str);
        }
    }

}
