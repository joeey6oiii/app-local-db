package dataBase;

import java.lang.reflect.Constructor;
import java.sql.SQLOutput;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.lang.reflect.Field;
import java.util.Objects;

public class DataBase <T>{
    private LinkedHashSet <T> dataBase = new LinkedHashSet<>();
    Class<T> t;

    public Collection<T> getCollection() {
        return dataBase;
    }
}
