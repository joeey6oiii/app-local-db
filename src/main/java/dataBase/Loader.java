package dataBase;

import defaultClasses.*;
import helpFun.*;
import validators.PersonValidator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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
        System.out.print("Would you like to delete all objects with invalid parameters? Type [Y/N] \n$ ");
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
                while (!personValidator.getNameValidator().validate(person.getName()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid name for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to set a new name for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        System.out.print("Input name: String (not null) \n$ ");
                        person.setName(scanner.nextLine());
                    }
                    if (!delete && !token) {
                        System.out.println("New name={" + person.getName() + "} for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                while (!personValidator.getCoordinatesValidator().validate(person.getCoordinates()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid coordinates for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to create new coordinates for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        Coordinates coordinates = new Coordinates();
                        boolean checkedX = false; boolean checkedY = false;
                        System.out.print("Input x: Integer (not null) \n$ ");
                        do {
                            try {
                                coordinates.setX(Integer.valueOf(scanner.nextLine()));
                                checkedX = true;
                            } catch (Exception e) {
                                System.out.print("Input x: Integer (not null) \n$ ");
                            }
                        } while (!checkedX);
                        System.out.print("Input y: Float (not null) \n$ ");
                        do {
                            try {
                                coordinates.setY(Float.valueOf(scanner.nextLine()));
                                checkedY = true;
                            } catch (Exception e) {
                                System.out.print("Input y: Float (not null) \n$ ");
                            }
                        } while (!checkedY);
                        person.setCoordinates(coordinates);
                    }
                    if (!delete && !token) {
                        System.out.println("New coordinates: x=" + person.getCoordinates().getX()
                                + " and y=" + person.getCoordinates().getY() + " for Person{id="
                                + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                while (!personValidator.getHeightValidator().validate(person.getHeight()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid height for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to set a new height for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        System.out.print("Input height: Long (not null) \n$ ");
                        do {
                            try {
                                person.setHeight(Long.valueOf(scanner.nextLine()));
                                checked = true;
                            } catch (Exception e) {
                                System.out.print("Input height: Long (not null) \n$ ");
                            }
                        } while (!checked);
                    }
                    if (!delete && !token) {
                        System.out.println("New height=" + person.getHeight() + " for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                while (!personValidator.getBirthdayValidator().validate(person.getBirthday()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid birthday for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to set a new birthday for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        LocalDateTime localDateTimeBirthday = null;
                        System.out.print("Input birthday: LocalDateTime (not null). Format: yyyy-MM-dd HH:mm:ss \n$ ");
                        do {
                            try {
                                strBirthday = scanner.nextLine();
                                localDateTimeBirthday = StringToLocalDatetimeParser.stringToLocalDateTime(strBirthday);
                                checked = true;
                            } catch (Exception e) {
                                System.out.print("Input birthday: LocalDateTime (not null)." +
                                        " Format: yyyy-MM-dd HH:mm:ss \n$ ");
                            }
                        } while (!checked);
                        person.setBirthday(localDateTimeBirthday);
                    }
                    if (!delete && !token) {
                        System.out.println("New birthday=" + person.getBirthday() + " for Person{id="
                                + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                while (!personValidator.getPassportIDValidator().validate(person.getPassportID()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid passportID for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to set a new passportID for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        System.out.print("Input passportID: String (nullable;" +
                                " range: 4 <= Input <= 32) \n$ ");
                        String passportID = scanner.nextLine();
                        if (Objects.equals(passportID, "") || Objects.equals(passportID, "null")) {
                            passportID = null;
                        }
                        person.setPassportID(passportID);
                    }
                    if (!delete && !token) {
                        System.out.println("New passportID={" + person.getPassportID()
                                + "} for Person{id=" + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                while (!personValidator.getLocationValidator().validate(person.getLocation()) && !delete && !token) {
                    System.out.println();
                    System.out.println("Invalid location for Person{id=" + person.getId() + "}");
                    System.out.print("Would you like to create a new location for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters) \n$ ");
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
                        boolean checkedX = false; boolean checkedY = false; boolean checkedZ = false;
                        System.out.println("Creating new Location...");
                        System.out.println(ANSI_YELLOW + "Previous location data was:"
                                + ANSI_RESET + " name=" + person.getLocation().getName()
                                + ", x=" + person.getLocation().getX() + ", y=" + person.
                                getLocation().getY() + " and z=" + person.getLocation().getZ());
                        System.out.print("Would you like to create null location or continue creating new location?" +
                                " Type [Y/N] (Y will assign null location for Person{id=" + person.getId() + "}) \n$ ");
                        decision = scanner.nextLine();
                        while (!decision.equalsIgnoreCase("Y")
                                && !decision.equalsIgnoreCase("N")) {
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
                        Location location = new Location();
                        System.out.print("Input x: int \n$ ");
                        do {
                            try {
                                location.setX(Integer.parseInt(scanner.nextLine()));
                                checkedX = true;
                            } catch (Exception e) {
                                System.out.print("Input x: int \n$ ");
                            }
                        } while (!checkedX);
                        System.out.print("Input y: Double (not null) \n$ ");
                        do {
                            try {
                                location.setY(Double.valueOf(scanner.nextLine()));
                                checkedY = true;
                            } catch (Exception e) {
                                System.out.print("Input y: Double (not null) \n$ ");
                            }
                        } while (!checkedY);
                        System.out.print("Input z: int \n$ ");
                        do {
                            try {
                                location.setZ(Integer.parseInt(scanner.nextLine()));
                                checkedZ = true;
                            } catch (Exception e) {
                                System.out.print("Input z: int \n$ ");
                            }
                        } while (!checkedZ);
                        System.out.print("Input name: String (nullable) \n$ ");
                        String name = scanner.nextLine();
                        if (Objects.equals(name, "") || Objects.equals(name, "null")) {
                            location.setName(null);
                        }
                        else {
                            location.setName(name);
                        }
                        person.setLocation(location);
                    }
                    if (!delete && !token) {
                        System.out.println("New location: name=" + person.getLocation().getName()
                                + ", x=" + person.getLocation().getX() + ", y=" + person.getLocation().getY()
                                + " and z=" + person.getLocation().getZ() + " for Person{id="
                                + person.getId() + "} has been successfully set!"
                                + " If the validation failed, please, try again");
                    }
                    else {
                        SystemNotification.notification("DELETED: " + person);
                    }
                }
                if (!delete && !token) {
                    dataBase.getCollection().add(person);
                    System.out.println("Person{id=" + person.getId() + "}" +
                            " has been successfully added to the database!");
                }
            }
            else {
                SystemNotification.notification("DELETED: " + person);
            }
        }
        System.out.println();
        System.out.println(ANSI_YELLOW + "---Validation completed successfully!---" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "---Data upload completed successfully!---" + ANSI_RESET);
        System.out.println();
    }

    private static String decision(){
        String decision = scanner.nextLine();
        while (!decision.equalsIgnoreCase("Y")
                && !decision.equalsIgnoreCase("N")
                && !decision.equalsIgnoreCase("D")) {
            decision = scanner.nextLine();
        }
        return decision;
    }
}