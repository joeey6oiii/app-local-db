package generators;

import defaultClasses.Color;
import defaultClasses.Location;
import defaultClasses.Person;
import helpFun.StringToLocalDatetimeParser;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonGenerator implements Generate {
    public Person generate() {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        person.setName(name);
        System.out.println("Creating coordinates:");
        CoordinatesGenerator coordinatesGenerator = new CoordinatesGenerator();
        person.setCoordinates(coordinatesGenerator.generate());
        System.out.print("Enter height (int): ");
        Long height = scanner.nextLong();
        person.setHeight(height);
        System.out.print("Enter birthday in format yyyy-MM-dd HH:mm:ss : ");
        System.out.println("If you don't want to chose birthday press ENTER");
        String test = scanner.nextLine(); // он кушает /n в буфере
        test = scanner.nextLine();
        if (test == "")
            person.setBirthday(null);
        else {
            LocalDateTime date = StringToLocalDatetimeParser.stringToLocalDateTime(test);
            person.setBirthday(date);
        }
        System.out.print("Enter passportID: ");
        String passportId = scanner.next();
        person.setPassportID(passportId);
        System.out.println("Choose one of the hair colors");
        Color.listValues();
        System.out.println("If you don't want to chose hair color press ENTER");
        String str = scanner.nextLine();//Сюда налепить валидатор
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
        person.setLocation(locationGenerator.generate());

        return person;
    }
}