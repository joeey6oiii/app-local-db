package commands;

import dataBase.DataBase;

public abstract class BaseCommand {
    public abstract void execute(DataBase obj);
    public abstract void describe();
}
