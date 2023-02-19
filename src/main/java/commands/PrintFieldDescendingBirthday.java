package commands;

import dataBase.DataBase;
import defaultClasses.Person;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PrintFieldDescendingBirthday extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        ArrayList<LocalDateTime> list = new ArrayList<>(obj.getCollection().size());
        for (Person person : obj.getCollection()) {
            list.add(person.getBirthday());
        }
        for (LocalDateTime localDateTime : list) {
            for (LocalDateTime localDateTime1 : list) {
                if (localDateTime.isAfter(localDateTime1)) {
                    list.set(list.indexOf(localDateTime), localDateTime1);
                    list.set(list.indexOf(localDateTime1), localDateTime);
                }
            }
        }
        for (LocalDateTime localDateTime : list) {
            System.out.println(localDateTime);
        }
    }

    @Override
    public void describe() {
        System.out.println("Outputs the \"birthday\" values of all elements in the database in descending order");
    }
}
