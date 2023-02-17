package dataBase;

import defaultClasses.*;
import validators.PersonValidator;

import java.util.Objects;
import java.util.Scanner;

public class Loader {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean token = false;

    public Loader(){}

    public boolean getToken(){
        return this.token;
    }

    public void setToken(boolean token){
        this.token = token;
    }

    public void assertToken() {
        System.out.println("Would you like to delete all objects with invalid parameters? Type Y/N");
        System.out.print("$ ");
        String decision = scanner.nextLine();
        while (!decision.equalsIgnoreCase("Y") && !decision.equalsIgnoreCase("N")) {
            System.out.print("$ ");
            decision = scanner.nextLine();
        }
        if (decision.equalsIgnoreCase("Y")) {
            this.token = true;
        }
    }

    public void load(DataBase dataBase, Person ... people){
        PersonValidator personValidator = new PersonValidator();
        for (Person person : people) {
            if(personValidator.validate(person)) {
                dataBase.getCollection().add(person);
            }
            else if (!token){
                boolean delete = false;
                while (!personValidator.getNameValidator().validate(person.getName()) && !delete && !token) {
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
                        System.out.println("Input name: String (not null)"); System.out.print("$ ");
                        person.setName(scanner.nextLine());
                    }
                    if (!delete && !token) {
                        System.out.println("The new name={" + person.getName() + "} for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                    else {
                        System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
                    }
                }
                while (!personValidator.getCoordinatesValidator().validate(person.getCoordinates()) && !delete && !token) {
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
                        Coordinates coordinates = new Coordinates();
                        boolean checkedX = false; boolean checkedY = false;
                        System.out.println("Input x: Integer (not null)"); System.out.print("$ ");
                        do {
                            try {
                                coordinates.setX(scanner.nextInt());
                                checkedX = true;
                            } catch (Exception e) {
                                System.out.println("Input x: Integer (not null)"); System.out.print("$ ");
                                scanner.next();
                            }
                        } while (!checkedX);
                        System.out.println("Input y: Float (not null)"); System.out.print("$ ");
                        do {
                            try {
                                coordinates.setY(scanner.nextFloat());
                                checkedY = true;
                            } catch (Exception e) {
                                System.out.println("Input y: Float (not null)"); System.out.print("$ ");
                            }
                        } while (!checkedY);
                        person.setCoordinates(coordinates);
                    }
                    if (!delete && !token) {
                        System.out.println("The new coordinates: x=" + person.getCoordinates().getX()
                                + " and y=" + person.getCoordinates().getY() + " for Person{id="
                                + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
                    }
                }
                while (!personValidator.getHeightValidator().validate(person.getHeight()) && !delete && !token) {
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
                        System.out.println("Input height: Long (not null)"); System.out.print("$ ");
                        do {
                            try {
                                person.setHeight(scanner.nextLong());
                                checked = true;
                            } catch (Exception e) {
                                System.out.println("Input height: Long (not null)"); System.out.print("$ ");
                                scanner.next();
                            }
                        } while (!checked);
                    }
                    if (!delete && !token) {
                        System.out.println("The new height=" + person.getHeight() + " for Person{id=" + person.getId()
                                + "} has been successfully set! If the validation failed, please, try again");
                    }
                    else {
                        System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
                    }
                }
                while (!personValidator.getPassportIDValidator().validate(person.getPassportID()) && !delete && !token) {
                    System.out.println("Invalid passportID for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to set a new passportID for Person{id="
                            + person.getId() + "}? Type [Y/N/D] (N automatically deletes object," +
                            " D deletes this and all following objects with invalid parameters)");
                    String decision = scanner.nextLine();
                    while (!decision.equalsIgnoreCase("Y")
                            && !decision.equalsIgnoreCase("N")
                            && !decision.equalsIgnoreCase("D")) {
                        System.out.print("$ ");
                        decision = scanner.nextLine();
                    }
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
                        System.out.println("Input passportID: String (nullable;" +
                                " range: 4 <= Input <= 32)"); System.out.print("$ ");
                        String passportID = scanner.nextLine();
                        if (Objects.equals(passportID, "")) {
                            person.setPassportID(null);
                            break;
                        }
                        person.setPassportID(passportID);
                    }
                    if (!delete && !token) {
                        System.out.println("The new passportID={" + person.getPassportID()
                                + "} for Person{id=" + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
                    }
                }
                while (!personValidator.getLocationValidator().validate(person.getLocation()) && !delete && !token) {
                    System.out.println("Invalid location for Person{id=" + person.getId() + "}");
                    System.out.println("Would you like to create a new location for Person{id="
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
                        boolean checkedX = false; boolean checkedY = false; boolean checkedZ = false;
                        System.out.println("Creating new Location...");
                        Location location = new Location();
                        System.out.println("Input x: int"); System.out.print("$ ");
                        do {
                            try {
                                location.setX(scanner.nextInt());
                                checkedX = true;
                            } catch (Exception e) {
                                System.out.println("Input x: int"); System.out.print("$ ");
                                scanner.next();
                            }
                        } while (!checkedX);
                        System.out.println("Input y: Double (not null)"); System.out.print("$ ");
                        do {
                            try {
                                location.setY(scanner.nextDouble());
                                checkedY = true;
                            } catch (Exception e) {
                                System.out.println("Input y: Double (not null)"); System.out.print("$ ");
                                scanner.next();
                            }
                        } while (!checkedY);
                        System.out.println("Input z: int"); System.out.print("$ ");
                        do {
                            try {
                                location.setZ(scanner.nextInt());
                                checkedZ = true;
                            } catch (Exception e) {
                                System.out.println("Input z: int"); System.out.print("$ ");
                                scanner.next();
                            }
                        } while (!checkedZ);
                        System.out.println("Input name: String (nullable)"); System.out.print("$ ");
                        String name = scanner.nextLine();
                        if (Objects.equals(name, "")) {
                            location.setName(null);
                        }
                        else {
                            location.setName(name);
                        }
                        person.setLocation(location);
                    }
                    if (!delete && !token) {
                        System.out.println("The new location=" + person.getLocation()
                                + " for Person{id=" + person.getId() + "} has been successfully set!" +
                                " If the validation failed, please, try again");
                    }
                    else {
                        System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
                    }
                }
            }
            else {
                System.out.println("SYSTEM NOTIFICATION: DELETED=" + person);
            }
        }
        System.out.println("---Validation completed successfully!---");
        System.out.println("---Data upload completed successfully!---");
    }

    private static String decision(){
        System.out.print("$ ");
        String decision = scanner.nextLine();
        while (!decision.equalsIgnoreCase("Y")
                && !decision.equalsIgnoreCase("N")
                && !decision.equalsIgnoreCase("D")) {
            decision = scanner.nextLine();
        }
        return decision;
    }
}