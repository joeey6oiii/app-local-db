package dataBase;

import defaultClasses.Person;

import java.time.LocalDateTime;
import java.util.HashSet;

public class DataBase {
    private HashSet<Person> dataBase = new HashSet<>();
    private LocalDateTime initializationTime;

    public DataBase(){
        initializationTime = LocalDateTime.now();
    }

    public HashSet<Person> getCollection() {
        return dataBase;
    }

    public long getSizeOfTheCollection(){
        return dataBase.size();
    }

    public LocalDateTime getInitializationTime (){
        return initializationTime;
    }

    public Class getTypeOfTheCollection() {
        return dataBase.getClass();
    }
}
