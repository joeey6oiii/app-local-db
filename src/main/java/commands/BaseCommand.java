package commands;

import dataBase.DataBase;

import java.io.IOException;

public abstract class BaseCommand {
    public abstract void execute(DataBase obj) throws IOException;

    public abstract void describe();
}
