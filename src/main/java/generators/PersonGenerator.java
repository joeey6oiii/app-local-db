package generators;

import defaultClasses.Color;
import defaultClasses.Coordinates;
import defaultClasses.Location;
import defaultClasses.Person;
import helpFun.StringToLocalDatetimeParser;
import validators.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonGenerator implements Generate {
    public Person generate() {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Enter name \n$ ");
        String name = scanner.nextLine();
        while (!new NameValidator().validate(name)) {
            System.out.print("Incorrect name. Enter name again \n$ ");
            name = scanner.nextLine();
        }
        person.setName(name);
        System.out.println("Creating coordinates:");
        CoordinatesGenerator coordinatesGenerator = new CoordinatesGenerator();
        Coordinates coordinates = coordinatesGenerator.generate();
        while (!new CoordinatesValidator().validate(coordinates)) {
            System.out.print("Incorrect coordinates. Enter coordinates again \n$ ");
            coordinates = coordinatesGenerator.generate();
        }
        person.setCoordinates(coordinates);
        System.out.print("Enter height (Long) \n$ ");
        Long height = (long) -10;
        while (!new HeightValidator().validate(height)) {
            try {
                height = Long.parseLong(scanner.next());
                if (!new HeightValidator().validate(height))
                    System.out.print("Incorrect height. Enter height again \n$ ");
            } catch (Exception e) {
                System.out.print("Incorrect height. Enter height again \n$ ");
            }

        }
        person.setHeight(height);
        System.out.print("Enter birthday in format yyyy-MM-dd HH:mm:ss ");
        System.out.print("If you don't want to chose birthday press ENTER \n$ ");
        String test = scanner.nextLine(); // он кушает /n в буфере
        test = scanner.nextLine();
        boolean flag = true;
        LocalDateTime date = null;
        while (flag) {
            try {
                if (test == "") {
                    person.setBirthday(null);
                    System.out.println("Birthday date is null");
                    break;
                }
                else {
                    date = StringToLocalDatetimeParser.stringToLocalDateTime(test);
                    flag = false;
                }
            } catch (Exception e){
                System.out.print("Incorrect. Enter the date in format yyyy-MM-dd HH:mm:ss : If you don't want to chose birthday press ENTER \n$ ");
                test = scanner.nextLine();
            }
        }
        person.setBirthday(date);
        System.out.print("Enter passportID \n$ ");
        String passportId = scanner.next();
        while(!new PassportIDValidator().validate(passportId)) {
            System.out.println("Incorrect passportId. PassportId length must be in range [4, 32] \n$ ");
            passportId = scanner.next();
        }
        person.setPassportID(passportId);
        System.out.println("Choose one of the hair colors");
        Color.listValues();
        System.out.println("If you don't want to chose hair color press ENTER");
        //TODO налепить валидатор
        String str;
        str = scanner.nextLine();
        Color cl;
        if (str == "") {
            cl = null;
        } else {
            cl = Color.getColorByName(str.toLowerCase());
        }
        person.setHairColor(cl);
        System.out.println("Creating Location:");
        LocationGenerator locationGenerator = new LocationGenerator();
        Location location = locationGenerator.generate();
        while (!new LocationValidator().validate(location)){
            System.out.println("Incorrect location");
            location = locationGenerator.generate();
        }
        person.setLocation(locationGenerator.generate());

        return person;
    }
}