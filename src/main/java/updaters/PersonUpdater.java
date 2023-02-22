package updaters;

import defaultClasses.*;
import generators.*;
import helpFun.Reflection;
import helpFun.StringToDateParser;
import validators.PersonValidator;

import java.util.*;

public class PersonUpdater implements UpdateAble<Person> {
    private static final Scanner scanner;
    private static final PersonValidator personValidator;
    private static final Map<String, Generate> map;
    private static final List<String> list;

    static {
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
        System.out.println("\u001B[33mWelcome to the Person Updater\u001B[0m");
        System.out.print("What would you like to update for " + person + "? \nType [Field name]" +
                " or \"exit\" to leave the Person Updater. \u001B[33mNota bene:\u001B[0m field name" +
                " is case sensitive\n$ "); String field = "";
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
                    System.out.println("\u001B[31m" + e.getMessage() + "\n" + e.getCause() + "\u001B[0m"); System.exit(0);
                }
                var previous_value = Reflection.getValue(person, field); Reflection.setValue(person, field, fieldClass, parameter);
                if (personValidator.validate(person)) {
                    System.out.println("Updated " + field + " for Person{id=" + person.getId() + "}"); type();
                } else {
                    Reflection.setValue(person, field, fieldClass, previous_value);
                    System.out.print("\u001B[31mValidation failed\u001B[0m" + ", please, try again\n$ ");
                }
            } else if (list.contains(field)) {
                var previous_value = Reflection.getValue(person, field);
                boolean boolBirthday = field.equalsIgnoreCase("BIRTHDAY");
                boolean boolHeight = field.equalsIgnoreCase("HEIGHT");
                if (boolBirthday) {
                    System.out.print("Input " + field + " (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                    boolean checked = false; String strBirthday; Date birthday = null;
                    do {
                        try {
                            strBirthday = scanner.nextLine();
                            birthday = StringToDateParser.stringToDate(strBirthday); checked = true;
                        } catch (Exception e) {
                            System.out.print("Input " + field + " (not null). Format: yyyy-MM-dd HH:mm:ss\n$ ");
                        }
                    } while (!checked);
                    Reflection.setValue(person, field, Date.class, birthday);
                } else if (boolHeight){
                    System.out.print("Input " + field + "\n$ "); boolean checked = false; int height = 0;
                    do {
                        try {
                            height = Integer.parseInt(scanner.nextLine()); checked = true;
                        } catch (Exception e) {
                            System.out.print("Input " + field + "\n$ ");
                        }
                    } while (!checked);
                    Reflection.setValue(person, field, int.class, height);
                } else {
                    System.out.print("Input " + field + " (not null)\n$ ");
                    Reflection.setValue(person, field, String.class, scanner.nextLine());
                }
                if (personValidator.validate(person)) {
                    System.out.println("Updated " + field + " for Person{id=" + person.getId() + "}");
                    type();
                } else {
                    if (boolBirthday) {
                        Reflection.setValue(person, field, Date.class, previous_value);
                    } else if (boolHeight) {
                        Reflection.setValue(person, field, int.class, previous_value);
                    } else {
                        Reflection.setValue(person, field, String.class, previous_value);
                    }
                    System.out.print("\u001B[31mValidation failed\u001B[0m, please, try again\n$ ");
                }
            }
            else {
                System.out.print("No such field or field is unavailable to update\n$ ");
            }
        }
        System.out.println("\u001B[33mExit Person Updater\u001B[0m");
    }

    private static void type() {
        System.out.print("Type [Field name] to update anything else or" +
                " \"exit\" to exit the Person Updater. \u001B[33mNota bene:\u001B[0m" + " field name is case sensitive\n$ ");
    }
}