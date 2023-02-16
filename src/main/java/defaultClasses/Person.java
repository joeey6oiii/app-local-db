package defaultClasses;

import helpFun.StringToLocalDatetimeParser;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Person implements Creatable{
    private static Long identifier = 0L;
    private final Long id;
    private String name;
    private Coordinates coordinates;
    private final java.time.LocalDate creationDate;
    private Long height;
    private java.time.LocalDateTime birthday;
    private String passportID;
    private Color hairColor;
    private Location location;

    public Person(){
        this.id = ++identifier;
        this.creationDate = java.time.LocalDate.now();
    }

    public Person(String name, Coordinates coordinates, Long height,
                  java.time.LocalDateTime birthday, String passportID,
                  Color hairColor, Location location){
        this.id = ++identifier;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.height = height;
        this.birthday = birthday;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.location = location;
    }
    //в create будем лепить валидаторы
    public Person create (){
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        person.setName(name);
        System.out.println("Creating coordinates:");
        Coordinates coordinates = new Coordinates();
        person.setCoordinates(coordinates.create());
        System.out.print("Enter height (int): ");
        Long height = scanner.nextLong();
        person.setHeight(height);
        System.out.print("Enter birthday in format yyyy-MM-dd HH:mm : ");
        String test = scanner.nextLine(); // он кушает /n в буфере
        test = scanner.nextLine();
        LocalDateTime date = StringToLocalDatetimeParser.stringToLocalDateTime(test);
        person.setBirthday(date);
        System.out.print("Enter passportID: ");
        String passportId = scanner.next();
        person.setPassportID(passportId);
        System.out.println("Choose one of the hair colors");
        Color.showColor();
        System.out.println("If you don't want to chose hair color press s");
        String str = scanner.next();//Сюда налепить валидатор
        Color cl;
        if (str == "s"){
            cl = null;
        }
        else {
            cl = Color.getColorByName(str.toLowerCase());
        }
        person.setHairColor(cl);
        System.out.println("Creating Location:");
        Location location1 = new Location();
        person.setLocation(location1.create());

        return person;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public java.time.LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(java.time.LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", birthday=" + birthday +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id)
                && Objects.equals(name, person.name)
                && Objects.equals(coordinates, person.coordinates)
                && Objects.equals(creationDate, person.creationDate)
                && Objects.equals(height, person.height)
                && Objects.equals(birthday, person.birthday)
                && Objects.equals(passportID, person.passportID)
                && hairColor == person.hairColor
                && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, birthday, passportID, hairColor, location);
    }
}
