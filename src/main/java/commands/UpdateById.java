package commands;

import dataBase.DataBase;
import defaultClasses.Person;
import updaters.PersonUpdater;

import java.io.IOException;

public class UpdateById extends BaseCommand {
    private static final PersonUpdater personUpdater;

    static {
        personUpdater = new PersonUpdater();
    }

    @Override
    public void execute(DataBase obj) throws IOException {
        boolean found = false;
        for (Person person : obj.getCollection()) {
            if (person.getId() == Long.parseLong(super.getParameter())) {
                found = true;
                personUpdater.update(person);
            }
        }
        if (!found) {
            System.out.println("No person matches id=" + super.getParameter());
        }
    }

    @Override
    public void describe() {
        System.out.println("Allows to reassign values to objects in the database");
    }
}
