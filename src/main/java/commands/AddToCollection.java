package commands;

import dataBase.*;
import defaultClasses.Person;
import generators.PersonGenerator;

import java.util.ArrayList;
import java.util.List;

public class AddToCollection extends BaseCommand{
    public void execute(DataBase obj){
        PersonGenerator personGenerator = new PersonGenerator();
        Person person = personGenerator.generate();
        List<Person> list = new ArrayList<>();
        list.add(person);
        Loader loader = new Loader();
        loader.load(GlobalObj.dataBase, list);
    }
    public void describe(){
        System.out.println("Creates and adds an element to the collection");
    }
}
