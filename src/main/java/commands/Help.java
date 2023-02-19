package commands;

import dataBase.DataBase;

import java.io.IOException;

public class Help extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        // TODO
    }

    @Override
    public void describe() {
        System.out.println("Displays information about console application commands");
    }
}
