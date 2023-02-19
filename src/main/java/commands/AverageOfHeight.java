package commands;

import dataBase.DataBase;
import defaultClasses.Person;

import java.io.IOException;
import java.util.Iterator;

public class AverageOfHeight extends BaseCommand {

    @Override
    public void execute(DataBase obj) throws IOException {
        Iterator<Person> it = obj.getCollection().iterator();
        int sum = 0;
        int count = 0;
        while (it.hasNext()){
            Person person = it.next();
            sum += person.getHeight();
            count += 1;
        }
        System.out.println("The average \"height\" value is: " + sum/count);
    }

    @Override
    public void describe() {
        System.out.println("Outputs the average value of the \"height\" field of all elements in the database");
    }
}
