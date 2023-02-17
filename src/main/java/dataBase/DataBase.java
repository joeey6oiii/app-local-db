package dataBase;

import defaultClasses.Person;

import java.lang.reflect.Constructor;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.lang.reflect.Field;
import java.util.Objects;

public class DataBase {
    private LinkedHashSet <Person> dataBase = new LinkedHashSet<>();
    private LocalDateTime initializationTime;

    public DataBase(){
        initializationTime = LocalDateTime.now();
    }

    public LinkedHashSet<Person> getCollection() {
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
