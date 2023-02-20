package updaters;

import defaultClasses.*;
import generators.*;
import helpFun.StringToLocalDatetimeParser;
import validators.PersonValidator;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonUpdater implements UpdateAble<Person> {
    private static final String ANSI_YELLOW;
    private static final String ANSI_RED;
    private static final String ANSI_RESET;
    private static final Scanner scanner;
    private static final PersonValidator personValidator;
    private static final Map<String, Generate> map;

    static {
        ANSI_YELLOW = "\u001B[33m";
        ANSI_RED = "\u001B[31m";
        ANSI_RESET = "\u001B[0m";

        scanner = new Scanner(System.in);

        personValidator = new PersonValidator();

        map = new LinkedHashMap<>();
        map.put("hairColor", new ColorGenerator());
        map.put("location", new LocationGenerator());
        map.put("coordinates", new CoordinatesGenerator());
    }

    @Override
    public void update(Person person) {
        System.out.println(ANSI_YELLOW + "Welcome to the Person Updater!" + ANSI_RESET);
        System.out.print("What would you like to update for " + person + "? \nType [Field name]" +
                " or \"exit\" to leave the Person Updater (" + ANSI_YELLOW + "Nota bene:" + ANSI_RESET
                + " field name is case sensitive) \n$ ");
        String field = "";
        while (!field.equalsIgnoreCase("EXIT")) {
            field = scanner.nextLine();
            if (map.containsKey(field)) {
                Class<?> fieldClass = null;
                var parameter = map.get(field).generate();
                try {
                    fieldClass = person.getClass().getDeclaredField(field).getType();
                } catch (NoSuchFieldException e) {
                    System.out.print("No such field \n$ ");
                }
                field = Character.toUpperCase(field.charAt(0)) + field.substring(1);
                field = "set" + field;
                try {
                    person.getClass().getMethod(field, fieldClass).invoke(person, parameter);
                } catch (SecurityException | NoSuchMethodException
                         | InvocationTargetException | IllegalAccessException e) {
                    System.out.print("Something went wrong, please, try again \n$ ");
                }
                if (personValidator.validate(person)) {
                    System.out.println(field.substring(3) + " has been successfully" +
                            " updated for Person{id=" + person.getId() + "}!");
                    type();
                } else {
                    System.out.print(ANSI_RED + "Validation failed" +
                            ANSI_RESET + ", please, try again \n$ ");
                }
            } else {
                if (field.equalsIgnoreCase("EXIT")) {
                    break;
                }
                else if (field.equalsIgnoreCase("NAME")) {
                    var previous_value = person.getName();
                    System.out.print("Input name: String (not null) \n$ ");
                    person.setName(scanner.nextLine());
                    if (personValidator.getNameValidator().validate(person.getName())) {
                        System.out.println("Name has been successfully" +
                                " updated for Person{id=" + person.getId() + "}!");
                        type();
                    } else {
                        person.setName(previous_value);
                        System.out.print(ANSI_RED + "Validation failed" +
                                ANSI_RESET + ", please, try again \n$ ");
                    }
                }
                else if (field.equalsIgnoreCase("PASSPORTID")) {
                    var previous_value = person.getPassportID();
                    System.out.print("Input passportId: String (nullable; range: 4 <= Input <= 32) \n$ ");
                    person.setPassportID(scanner.nextLine());
                    if (personValidator.getPassportIDValidator().validate(person.getPassportID())) {
                        System.out.println("PassportId has been successfully updated for Person{id="
                                + person.getId() + "}!");
                        type();
                    } else {
                        person.setPassportID(previous_value);
                        System.out.print(ANSI_RED + "Validation failed" +
                                ANSI_RESET + ", please, try again \n$ ");
                    }
                }
                else if (field.equalsIgnoreCase("HEIGHT")) {
                    var previous_value = person.getHeight();
                    System.out.print("Input height: Long (not null) \n$ ");
                    boolean checked = false;
                    do {
                        try {
                            person.setHeight(Long.valueOf(scanner.nextLine()));
                            if (personValidator.getHeightValidator().validate(person.getHeight())) {
                                System.out.println("Height has been successfully updated for Person{id="
                                        + person.getId() + "}!");
                            } else {
                                person.setHeight(previous_value);
                                System.out.print(ANSI_RED + "Validation failed" +
                                        ANSI_RESET + ", please, try again \n$ ");
                            }
                            type();
                            checked = true;
                        } catch (Exception e) {
                            System.out.print("Input height: Long (not null) \n$ ");
                        }
                    } while (!checked);
                } else if (field.equalsIgnoreCase("BIRTHDAY")) {
                    var previous_value = person.getBirthday();
                    boolean checked = false;
                    String strBirthday;
                    LocalDateTime localDateTimeBirthday = null;
                    System.out.print("Input birthday: LocalDateTime (not null)." +
                            " Format: yyyy-MM-dd HH:mm:ss \n$ ");
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
                    if (personValidator.getBirthdayValidator().validate(person.getBirthday())) {
                        System.out.println("Birthday has been successfully updated for Person{id="
                                + person.getId() + "}!");
                        type();
                    } else {
                        person.setBirthday(previous_value);
                        System.out.print(ANSI_RED + "Validation failed" +
                                ANSI_RESET + ", please, try again \n$ ");
                    }
                }
                else {
                    System.out.print("No such field or field is unavailable to update \n$ ");
                }
            }
        }
        System.out.println(ANSI_YELLOW + "Exit Person Updater" + ANSI_RESET);
    }

    private static void type() {
        System.out.print("Type [Field name] to update anything else or" +
                " \"exit\" to exit the Person Updater (" + ANSI_YELLOW + "Nota bene:"
                + ANSI_RESET + " field name is case sensitive) \n$ ");
    }
}