package commands;

import dataBase.DataBase;

import java.io.IOException;

public class UpdateById extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        // TODO
    }

    @Override
    public void describe() {
        System.out.println("Allows to reassign values to objects in the database");
    }
}
