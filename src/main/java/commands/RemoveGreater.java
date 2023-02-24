package commands;

import dataBase.DataBase;
import dataBase.HeightComparator;
import defaultClasses.Person;
import generators.PersonGenerator;

import java.io.IOException;
import java.util.Iterator;

public class RemoveGreater extends  BaseCommand{
    public void execute(DataBase obj) throws IOException {
        PersonGenerator personGenerator = new PersonGenerator();
        Person person = personGenerator.generate();
        Iterator<Person> it = obj.getCollection().iterator();
        HeightComparator heightComparator = new HeightComparator();
        while(it.hasNext()){
            if (heightComparator.compare(it.next(), person)>0){
                it.remove();
            }
        }
    }

    public void describe() {
        System.out.println("Removes from the collection all elements greater than the specified");
    }
}
