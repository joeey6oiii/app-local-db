package commands;

import dataBase.DataBase;

import java.io.IOException;

public abstract class BaseCommand {
    public abstract void execute(DataBase obj) throws IOException;

    private String parameter;
    public BaseCommand(){
        parameter = null;
    }
    public BaseCommand(String obj){
        parameter = obj;
    }
    public abstract void describe();

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
