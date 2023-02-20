package commands;

import dataBase.DataBase;

import java.io.IOException;
import java.util.ArrayList;

public class CommandHistory extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        ArrayList<String> list = CommandHandler.getHistory();
        if (list.size() == 0) {
            System.out.println("No command history yet");
            return;
        }
        int i = 9;
        while (list.size() > i) {
            list.remove(list.size() - 1 - i);
        }
        System.out.println(list);
    }

    @Override
    public void describe() {
        System.out.println("Outputs last input 9 commands (without arguments)");
    }
}
