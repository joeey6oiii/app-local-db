import defaultClasses.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alexey", new defaultClasses.Coordinates(1, 2.0F),
                3L, java.time.LocalDateTime.now(), "12356", defaultClasses.Color.BROWN,
                new defaultClasses.Location(1, 2.0, 3, "Earth"));
        Person person2 = new Person("Dmitry", new defaultClasses.Coordinates(1, 2.0F),
                3L, java.time.LocalDateTime.now(), "123", defaultClasses.Color.BROWN,
                new defaultClasses.Location(1, 2.0, 3, "Moon"));
        System.out.println(person.getId());
        System.out.println(person2.getId());
    }
}
