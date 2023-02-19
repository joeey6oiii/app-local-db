package commands;

import dataBase.DataBase;

import java.io.IOException;
import java.util.Map;

public class Help extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        int l;
        for (Map.Entry<String, BaseCommand> entry : CommandHandler.getMap().entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            l = CommandHandler.getLongestCommand() - entry.getKey().length();
            while (l != 0) {
                stringBuilder.append(" ");
                l -= 1;
            }
            System.out.print(entry.getKey() + stringBuilder);
            entry.getValue().describe();
        }
    }

    @Override
    public void describe() {
        System.out.println("Displays information about console application commands");
    }
}
