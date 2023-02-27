package commands;

import dataBase.DataBase;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that implements the history command.
 */

public class CommandHistory extends BaseCommand {

    /**
     * When called, gets the history from the {@link CommandHandler} and checks the size of the history list. If size
     * equals zero, outputs a <code>String</code>, if size is between zero and nine, outputs the whole history <code>List</code>,
     * otherwise removes first values in the history list until it's size is nine, and then outputs history <code>List</code>.
     *
     * @param obj link to the database which contains the collection
     * @throws IOException
     */

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

    /**
     * A method that outputs the description of the command.
     */

    @Override
    public void describe() {
        System.out.println("Outputs last input 9 commands (without arguments)");
    }
}
