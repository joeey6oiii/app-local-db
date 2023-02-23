package defaultClasses;

import java.util.Date;
import java.util.Objects;

public class Person implements Generated, IsUpdateable, Comparable<Person> {
    private static Integer identifier = 0;
    private final Integer id;
    private String name;
    private Coordinates coordinates;
    private final java.util.Date creationDate;
    private int height;
    private java.util.Date birthday;
    private String passportID;
    private Color hairColor;
    private Location location;

    public Person() {
        this.id = ++identifier;
        this.creationDate = new Date();
    }

    public Person(String name, Coordinates coordinates, int height,
                  java.util.Date birthday, String passportID,
                  Color hairColor, Location location) {
        this.id = ++identifier;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.height = height;
        this.birthday = birthday;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.location = location;
    }

    public static Integer getIdentifier() {
        return identifier;
    }

    public Integer getId() {
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
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

    public java.util.Date getCreationDate() {
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

    public int compareTo (Person anotherPerson){
        return this.id-anotherPerson.id;
    }
}
