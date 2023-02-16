package commands;

import dataBase.DataBase;
import dataBase.GlobalObj;
import dataBase.Loader;
import defaultClasses.Person;
import generators.PersonGenerator;

public class AddToCollection extends BaseCommand{
    public void execute(DataBase obj){
        PersonGenerator personGenerator = new PersonGenerator();
        Person person = personGenerator.generate();
        Loader loader = new Loader();
        loader.load(GlobalObj.dataBase);
    }
    public void describe(){
        System.out.println("creates and adds an element to the collection");
    }
}
