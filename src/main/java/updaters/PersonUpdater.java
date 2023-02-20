package updaters;

import defaultClasses.Person;
import generators.CoordinatesGenerator;
import generators.LocationGenerator;

import java.util.Scanner;

public class PersonUpdater implements UpdateAble<Person> {
    private static final Scanner scanner;
    private static final CoordinatesGenerator coordinatesGenerator;
    private static final LocationGenerator locationGenerator;
    private static final String ANSI_YELLOW;
    private static final String ANSI_RESET;

    static {
        scanner = new Scanner(System.in);
        locationGenerator = new LocationGenerator();
        coordinatesGenerator = new CoordinatesGenerator();
        ANSI_YELLOW = "\u001B[33m";
        ANSI_RESET = "\u001B[0m";
    }

    @Override
    public void update(Person person) {
        System.out.println(ANSI_YELLOW + "Welcome to the Person Updater!" + ANSI_RESET);
        System.out.print("What would you like to update for " + person + "? \nType [Field name]" +
                " or \"exit\" to leave the Person Updater \n$ ");
        String field = scanner.nextLine();
        while (!field.equalsIgnoreCase("EXIT")) {
            System.out.print("$ ");
            field = scanner.nextLine();
            // todo
        }
        System.out.println(ANSI_YELLOW + "Exit Person Updater" + ANSI_RESET);
    }
}
