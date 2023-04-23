package commands;

import dataBase.GlobalObj;
import dataBase.Loader;
import defaultClasses.Person;
import generators.PersonGenerator;

import java.io.IOException;
import java.util.Collections;

/**
 * A class that implements the update_by_id command.
 */

public class UpdateById extends BaseCommand {

    /**
     * When called, iterates through the collection to find the {@link Person} object with the specified id. If not found,
     * outputs <code>String</code>, otherwise calls the {@link PersonGenerator#generate()} method on the found person.
     * @see PersonGenerator
     *
     * @throws IOException
     */

    @Override
    public void execute() throws IOException {
        boolean found = false;
        for (Person p : GlobalObj.dataBase.getCollection()) {
            if (p.getId() == Long.parseLong(super.getParameter())) {
                found = true;
                int id = p.getId();
                GlobalObj.dataBase.getCollection().remove(p);
                Person person = new PersonGenerator().generate();
                person.setId(id);
                new Loader().load(GlobalObj.dataBase, Collections.singletonList(person));
            }
        }
        if (!found) {
            System.out.println("No person matches id=" + super.getParameter());
        }
    }

    /**
     * A method that returns the description of the command.
     */

    @Override
    public String describe() {
        return "Allows to reassign values to objects in the database";
    }
}