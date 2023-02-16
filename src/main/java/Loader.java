import defaultClasses.Person;
import validators.PersonValidator;
import validators.ValidateAble;

import java.lang.reflect.Type;

public class Loader {
    public Loader(){}
    public void load(DataBase<Person> dataBase, Person ... people){
        ValidateAble<Person> personValidator = new PersonValidator();
        for (Person person : people) {
            personValidator.validate(person);
            dataBase.getCollection().add(person);
        }
    }
}
