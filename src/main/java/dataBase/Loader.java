package dataBase;

import dataBase.DataBase;
import defaultClasses.Person;
import validators.PersonValidator;
import validators.ValidateAble;

public class Loader {
    public Loader() {
    }

    public void load(DataBase dataBase, Person... people) {
        ValidateAble<Person> personValidator = new PersonValidator();
        for (Person person : people) {
            personValidator.validate(person);
            dataBase.getCollection().add(person);
        }
    }
}
