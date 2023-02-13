package defaultClasses;

public class Person {
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

}
