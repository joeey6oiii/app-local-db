package commands;

import dataBase.DataBase;

import java.io.IOException;

@FunctionalInterface
public interface CommandExecuteInterface {
    void execute(DataBase obj);
}
