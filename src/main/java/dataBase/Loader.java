package dataBase;

import defaultClasses.*;
import generators.CoordinatesGenerator;
import generators.LocationGenerator;
import helpFun.*;
import validators.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Loader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    private boolean token = false;

    public Loader(){}

    public boolean getToken(){
        return this.token;
    }

    public void setToken(boolean token){
        this.token = token;
    }

    public void assertToken() {
        System.out.print("Would you like to delete all objects with invalid parameters? Type [Y/N]\n$ ");
        String decision = scanner.nextLine();
        while (!decision.equalsIgnoreCase("Y") && !decision.equalsIgnoreCase("N")) {
            System.out.print("$ ");
            decision = scanner.nextLine();
        }
        if (decision.equalsIgnoreCase("Y")) {
            this.token = true;
        }
    }

    public void load(DataBase dataBase, List<Person> people){
        PersonValidator personValidator = new PersonValidator();
        for (Person person : people) {
            if(personValidator.validate(person)) {
                dataBase.getCollection().add(person);
            }
            else if (!token){
                boolean delete = false;
                NameValidator nameValidator = new NameValidator();
                CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
                HeightValidator heightValidator = new HeightValidator();
                BirthdayValidator birthdayValidator = new BirthdayValidator();
                PassportIDValidator passportIDValidator = new PassportIDValidator();
                LocationValidator locationValidator = new LocationValidator();
                while (!nameValidator.validate(person.getName()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid name for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to set a new name for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} has been successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    }
                    else {
                        System.out.print("Input name: String (not null)\n$ ");
                        person.setName(scanner.nextLine());
                    }
                    if (!delete && !token) {
                        System.out.println("New name={" + person.getName() + "} for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                }
                while (!coordinatesValidator.validate(person.getCoordinates()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid coordinates for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to create new coordinates for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} has been successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    } else {
                        System.out.println("Creating new Coordinates...");
                        if (person.getCoordinates() != null) {
                            System.out.println(ANSI_YELLOW + "Previous coordinates data was:"
                                    + ANSI_RESET + " x=" + person.getCoordinates().getX()
                                    + ", y=" + person.getCoordinates().getY());
                        }
                        person.setCoordinates(new CoordinatesGenerator().generate());
                    }
                    if (!delete && !token && person.getCoordinates() != null) {
                        System.out.println("New coordinates: x=" + person.getCoordinates().getX()
                                + " and y=" + person.getCoordinates().getY() + " for Person{id="
                                + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                }
                while (!heightValidator.validate(person.getHeight()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid height for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to set a new height for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} has been successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    }
                    else {
                        boolean checked = false;
                        System.out.print("Input height: int\n$ ");
                        do {
                            try {
                                person.setHeight(Integer.parseInt(scanner.nextLine()));
                                checked = true;
                            } catch (Exception e) {
                                System.out.print("Input height: int\n$ ");
                            }
                        } while (!checked);
                    }
                    if (!delete && !token) {
                        System.out.println("New height=" + person.getHeight() + " for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                }
                while (!birthdayValidator.validate(person.getBirthday()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid birthday for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to set a new birthday for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    }
                    else {
                        boolean checked = false;
                        String strBirthday;
                        Date dateBirthday = null;
                        System.out.print("Input birthday: Date (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                            do {
                                try {
                                    strBirthday = scanner.nextLine();
                                    dateBirthday = StringToDateParser.stringToDate(strBirthday);
                                    checked = true;
                                } catch (Exception e) {
                                    System.out.print("Input birthday: Date (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                                }
                            } while (!checked);
                            person.setBirthday(dateBirthday);
                    }
                    if (!delete && !token) {
                        System.out.println("New birthday=" + person.getBirthday() + " for Person{id="
                                + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                }
                while (!passportIDValidator.validate(person.getPassportID()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid passportID for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to set a new passportID for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    }
                    else {
                        System.out.print("Input passportID: String (not null; range [5, +inf))\n$ ");
                        String passportID = scanner.nextLine();
                        person.setPassportID(passportID);
                    }
                    if (!delete && !token) {
                        System.out.println("New passportID={" + person.getPassportID()
                                + "} for Person{id=" + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                }
                while (!locationValidator.validate(person.getLocation()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid location for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to create a new location for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = decision();
                    if (decision.equalsIgnoreCase("N")) {
                        delete = true;
                        System.out.println("Person{id=" + person.getId() + "} has been successfully deleted");
                    }
                    else if (decision.equalsIgnoreCase("D")) {
                        token = true;
                        System.out.println("Person{id=" + person.getId() + "} and" +
                                " all following objects with invalid parameters will be deleted");
                    }
                    else {
                        System.out.println("Creating new Location...");
                        System.out.println(ANSI_YELLOW + "Previous location data was:"
                                + ANSI_RESET + " name=" + person.getLocation().getName()
                                + ", x=" + person.getLocation().getX() + " and y=" + person.getLocation().getY());
                        System.out.println("Would you like to create null location? Type [Y/N]");
                        decision = "";
                        while (!decision.equalsIgnoreCase("Y")
                                && !decision.equalsIgnoreCase("N")) {
                            System.out.print("$ ");
                            decision = scanner.nextLine();
                        }
                        if (decision.equalsIgnoreCase("Y")) {
                            person.setLocation(null);
                            System.out.println("New location=" + person.getLocation() + " for Person{id="
                                    + person.getId() + "} has been successfully set!");
                            break;
                        }
                        else {
                            System.out.println("Continue creating new location...");
                        }
                        person.setLocation(new LocationGenerator().generate());
                    }
                    if (!delete && !token && person.getLocation() != null) {
                        System.out.println("New location: name=" + person.getLocation().getName()
                                + ", x=" + person.getLocation().getX() + ", y=" + person.getLocation().getY()
                                + " for Person{id=" + person.getId() + "} has been successfully set!"
                                + " If the validation failed, please, try again");
                    }
                }
                if (!delete && !token) {
                    dataBase.getCollection().add(person);
                    System.out.println("Person{id=" + person.getId() + "}" +
                            " has been successfully added to the database!");
                }
            }
            else {
                System.out.println("\u001B[31m" + "DELETED: " + "\u001B[0m" + person);
            }
        }
        System.out.println();
        System.out.println(ANSI_YELLOW + "---Validation completed successfully!---" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "---Data upload completed successfully!---" + ANSI_RESET);
        System.out.println();
    }

    private static String decision(){
        String decision = "";
        while (!decision.equalsIgnoreCase("Y")
                && !decision.equalsIgnoreCase("N")
                && !decision.equalsIgnoreCase("D")) {
            System.out.print("$ ");
            decision = scanner.nextLine();
        }
        return decision;
    }
}