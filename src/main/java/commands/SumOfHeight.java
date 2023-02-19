package commands;

import dataBase.DataBase;
import defaultClasses.Person;

import java.io.IOException;
import java.util.Iterator;

public class SumOfHeight extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        Iterator<Person> it = obj.getCollection().iterator();
        int sum = 0;
        while (it.hasNext()){
            Person person = it.next();
            sum += person.getHeight();
        }
        System.out.println("Sum of \"height\" values is: " + sum);
    }

    @Override
    public void describe() {
        System.out.println("Outputs the sum of the \"height\" values of all elements in the database");
    }
}
