package commands;

import dataBase.DataBase;

@FunctionalInterface
public interface CommandExecuteInterface {
    void execute(DataBase obj);
}
