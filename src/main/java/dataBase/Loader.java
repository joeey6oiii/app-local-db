package dataBase;

import defaultClasses.*;
import generators.*;
import helpFun.*;
import validators.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * A class that allows to load objects to a database collection after a successful validation.
 */

public class Loader {
    private boolean token = false;

    /**
     * Creates a new Loader with initial token value {@code false}.
     */

    public Loader(){}

    /**
     * @return value of the token field
     */

    public boolean getToken(){
        return this.token;
    }

    /**
     * @param token sets the value of the token field
     */

    public void setToken(boolean token){
        this.token = token;
    }

    /**
     * Asks the user if they want to remove all objects with invalid parameters or change all the invalid values to
     * correct to add object to the collection.
     */

    public void assertToken() {
        System.out.println("\nWould you like to delete all objects with invalid parameters? Type [Y/N]");
        String decision = Decision.decision("Y", "N");
        if (decision.equalsIgnoreCase("Y")) { this.token = true; } System.out.print("\n");
    }

    /**
     * A method for loading objects after successful validation.
     * <p>
     * Each time asks the user if they want to change the invalid value, to delete object or to delete all objects with
     * invalid parameters (Last one sets the token field value to {@code true})
     *
     * @param dataBase link to the database which contains the collection
     * @param people a list of {@link Person} objects
     */

    public void load(DataBase dataBase, List<Person> people){
        for (Person person : people) {
            if(new PersonValidator().validate(person)) {
                dataBase.getCollection().add(person); dataBase.SortCollection(); System.out.println("\u001B[32mAdded:\u001B[0m " + person);
            } else if (!token){
                boolean delete = false; Scanner scanner = new Scanner(System.in);
                while (!new NameValidator().validate(person.getName()) && !delete && !token) {
                    System.out.println("\nInvalid name for " + person + "\nWould you like to set a new name for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes this and all" +
                            " following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        System.out.print("Input name: String (not null)\n$ "); person.setName(scanner.nextLine());
                    }
                    if (!delete && !token) {
                        System.out.println("Set new name=" + person.getName() + " for Person{id=" + person.getId()
                                + "}. If the validation failed, please, try again");
                    }
                }
                while (!new CoordinatesValidator().validate(person.getCoordinates()) && !delete && !token) {
                    System.out.println("\nInvalid coordinates for " + person + "\nWould you like to create new coordinates" +
                            " for Person{id=" + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes" +
                            " this and all following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        System.out.println("Creating new Coordinates..."); person.setCoordinates(new CoordinatesGenerator().generate());
                    }
                    if (!delete && !token && person.getCoordinates() != null) {
                        System.out.println("Set new coordinates: x=" + person.getCoordinates().getX() + " and y=" +
                                person.getCoordinates().getY() + " for Person{id=" + person.getId() + "}." + " If the" +
                                " validation failed, please, try again");
                    }
                }
                while (!new HeightValidator().validate(person.getHeight()) && !delete && !token) {
                    System.out.println("\nInvalid height for " + person + "\nWould you like to set a new height for" +
                            " Person{id=" + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes" +
                            " this and all following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        boolean checked = false; System.out.print("Input height: int\n$ ");
                        do {
                            try {
                                person.setHeight(Integer.parseInt(scanner.nextLine())); checked = true;
                            } catch (Exception e) { System.out.print("Input height: int\n$ "); }
                        } while (!checked);
                    }
                    if (!delete && !token) {
                        System.out.println("Set new height=" + person.getHeight() + " for Person{id=" + person.getId()
                                + "}. If the validation failed, please, try again");
                    }
                }
                while (!new BirthdayValidator().validate(person.getBirthday()) && !delete && !token) {
                    System.out.println("\nInvalid birthday for " + person + "\nWould you like to set a new birthday for" +
                            " Person{id=" + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes" +
                            " this and all following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        boolean checked = false; String strBirthday; Date dateBirthday = null;
                        System.out.print("Input birthday: Date (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                            do {
                                try {
                                    strBirthday = scanner.nextLine();
                                    dateBirthday = StringToDateParser.parse(strBirthday); checked = true;
                                } catch (Exception e) {
                                    System.out.print("Input birthday: Date (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                                }
                            } while (!checked); person.setBirthday(dateBirthday);
                    }
                    if (!delete && !token) {
                        System.out.println("Set new birthday=" + person.getBirthday() + " for Person{id="
                                + person.getId() + "}. If the validation failed, please, try again");
                    }
                }
                while (!new PassportIDValidator().validate(person.getPassportID()) && !delete && !token) {
                    System.out.println("\nInvalid passportID for " + person + "\nWould you like to set a new passportID" +
                            " for Person{id=" + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes" +
                            " this and all following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        System.out.print("Input passportID: String (not null; range [5, +inf))\n$ ");
                        String passportID = scanner.nextLine(); person.setPassportID(passportID);
                    }
                    if (!delete && !token) {
                        System.out.println("Set new passportID=" + person.getPassportID()
                                + " for Person{id=" + person.getId() + "}. If the validation failed, please, try again");
                    }
                }
                while (!new LocationValidator().validate(person.getLocation()) && !delete && !token) {
                    System.out.println("\nInvalid location for " + person + "\nWould you like to create a new location for" +
                            " Person{id=" + person.getId() + "}? Type [Y/N/D] (N automatically deletes object, D deletes this" +
                            " and all following objects with invalid parameters)"); String decision = Decision.decision("Y", "N", "D");
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else if (decision.equalsIgnoreCase("D")) {
                        this.token = true; System.out.println("\n\u001B[31mDeleted: \u001B[0m" + person);
                    } else {
                        System.out.println("Creating new Location...\n\u001B[33mPrevious location data was:" +
                                "\u001B[0m name=" + person.getLocation().getName() + ", x=" + person.getLocation().getX()
                                + " and y=" + person.getLocation().getY() + "\nWould you like to create null location? Type [Y/N]");
                        decision = Decision.decision("Y", "N");
                        if (decision.equalsIgnoreCase("Y")) {
                            person.setLocation(null);
                        } else {
                            boolean notNull = false; System.out.print("Continue creating new location...\n");
                            while (!notNull) {
                                person.setLocation(new LocationGenerator().generate()); notNull = person.getLocation() != null;
                            }
                        }
                    }
                    if (!delete && !token) {
                        if (person.getLocation() != null){
                            System.out.println("Set new location: name=" + person.getLocation().getName()
                                    + ", x=" + person.getLocation().getX() + ", y=" + person.getLocation().getY()
                                    + " for Person{id=" + person.getId() + "}. If the validation failed, please, try again");
                        } else { System.out.println("Set new location=" + person.getLocation() + " for Person{id=" + person.getId() + "}"); }
                    }
                }
                if (!delete && !token) {
                    dataBase.getCollection().add(person); dataBase.SortCollection(); System.out.println("\n\u001B[32mAdded:\u001B[0m " + person);
                }
            } else { System.out.println("\u001B[31mDeleted: \u001B[0m" + person); }
        }
        System.out.println("\n\u001B[33m---Validation completed successfully!---\n---Data upload completed successfully!---\u001B[0m\n");
    }
}