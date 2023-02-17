package dataBase;

import java.lang.reflect.Constructor;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.lang.reflect.Field;
import java.util.Objects;

public class DataBase<T> {
    private LinkedHashSet<T> dataBase = new LinkedHashSet<>();
    private LocalDateTime initializationTime;
    private Class<T> t;

    public DataBase() {
        initializationTime = LocalDateTime.now();
    }

    public Collection<T> getCollection() {
        return dataBase;
    }

    public long getSizeOfTheCollection() {
        return dataBase.size();
    }

    public LocalDateTime getInitializationTime() {
        return initializationTime;
    }

    public Class getTypeOfTheCollection() {
        return dataBase.getClass();
    }
}
