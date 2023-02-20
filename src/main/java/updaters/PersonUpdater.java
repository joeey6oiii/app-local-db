package updaters;

import defaultClasses.*;
import generators.*;
import helpFun.Reflection;
import helpFun.StringToLocalDatetimeParser;
import validators.PersonValidator;

import java.time.LocalDateTime;
import java.util.*;

public class PersonUpdater implements UpdateAble<Person> {
    private static final String ANSI_YELLOW;
    private static final String ANSI_RED;
    private static final String ANSI_RESET;
    private static final Scanner scanner;
    private static final PersonValidator personValidator;
    private static final Map<String, Generate> map;
    private static final List<String> list;

    static {
        ANSI_YELLOW = "\u001B[33m";
        ANSI_RED = "\u001B[31m";
        ANSI_RESET = "\u001B[0m";

        scanner = new Scanner(System.in);

        personValidator = new PersonValidator();

        map = new LinkedHashMap<>(3);
        map.put("hairColor", new ColorGenerator());
        map.put("location", new LocationGenerator());
        map.put("coordinates", new CoordinatesGenerator());

        list = new ArrayList<>(3);
        list.add("name");
        list.add("passportID");
        list.add("birthday");
        list.add("height");
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
            if (field.equalsIgnoreCase("EXIT")) {
                break;
            } else if (map.containsKey(field)) {
                Class<?> fieldClass = null;
                var parameter = map.get(field).generate();
                try {
                    fieldClass = person.getClass().getDeclaredField(field).getType();
                } catch (NoSuchFieldException e) {
                    System.out.println(ANSI_RED + e.getMessage() + "\n"
                            + e.getCause() + ANSI_RESET); System.exit(0);
                }
                var previous_value = Reflection.getValue(person, field);
                Reflection.setValue(person, field, fieldClass, parameter);
                if (personValidator.validate(person)) {
                    System.out.println(field + " has been successfully updated for Person{id=" + person.getId() + "}!");
                    type();
                } else {
                    Reflection.setValue(person, field, fieldClass, previous_value);
                    System.out.print(ANSI_RED + "Validation failed" + ANSI_RESET + ", please, try again \n$ ");
                }
            } else if (list.contains(field)) {
                var previous_value = Reflection.getValue(person, field);
                boolean boolBirthday = field.equalsIgnoreCase("BIRTHDAY");
                boolean boolHeight = field.equalsIgnoreCase("HEIGHT");
                if (boolBirthday) {
                    System.out.print("Input " + field + " (not null). Format: yyyy-MM-dd HH:mm:ss \n$ ");
                    boolean checked = false;
                    String strBirthday; LocalDateTime birthday = null;
                    do {
                        try {
                            strBirthday = scanner.nextLine();
                            birthday = StringToLocalDatetimeParser.stringToLocalDateTime(strBirthday);
                            checked = true;
                        } catch (Exception e) {
                            System.out.print("Input " + field + " (not null). Format: yyyy-MM-dd HH:mm:ss \n$ ");
                        }
                    } while (!checked);
                    Reflection.setValue(person, field, LocalDateTime.class, birthday);
                } else if (boolHeight){
                    System.out.print("Input " + field + " (not null) \n$ ");
                    boolean checked = false;
                    Long height = null;
                    do {
                        try {
                            height = Long.valueOf(scanner.nextLine());
                            checked = true;
                        } catch (Exception e) {
                            System.out.print("Input " + field + " (not null) \n$ ");
                        }
                    } while (!checked);
                    Reflection.setValue(person, field, Long.class, height);
                } else {
                    System.out.print("Input " + field + " (not null) \n$ ");
                    Reflection.setValue(person, field, String.class, scanner.nextLine());
                }
                if (personValidator.validate(person)) {
                    System.out.println(field + " has been successfully updated for Person{id=" + person.getId() + "}!");
                    type();
                } else {
                    if (boolBirthday) {
                        Reflection.setValue(person, field, LocalDateTime.class, previous_value);
                    } else if (boolHeight) {
                        Reflection.setValue(person, field, Long.class, previous_value);
                    } else {
                        Reflection.setValue(person, field, String.class, previous_value);
                    }
                    System.out.print(ANSI_RED + "Validation failed" +
                            ANSI_RESET + ", please, try again \n$ ");
                }
            }
            else {
                System.out.print("No such field or field is unavailable to update \n$ ");
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