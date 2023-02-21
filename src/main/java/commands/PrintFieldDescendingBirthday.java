package commands;

import dataBase.DataBase;
import defaultClasses.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PrintFieldDescendingBirthday extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        ArrayList<Date> list = new ArrayList<>(obj.getCollection().size());
        for (Person person : obj.getCollection()) {
            list.add(person.getBirthday());
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (Date date : list) {
            System.out.println(date);
        }
    }

    @Override
    public void describe() {
        System.out.println("Outputs the \"birthday\" values of all elements in the database in descending order");
    }
}
