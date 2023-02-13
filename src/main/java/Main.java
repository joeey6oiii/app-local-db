import defaultClasses.Coordinates;
import defaultClasses.Person;
import yamlsTools.YamlWriter;


import java.io.IOException;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("John", new Coordinates(1, 2.0f), 3L, LocalDateTime.now(), "123456", null, null);
        Person person2 = new Person("John", new Coordinates(1, 2.0f), 3L, LocalDateTime.now(), "123456", null, null);
        System.out.println(person.getId());
        String path = System.getenv("Lab5");
        System.out.println(path);
        System.out.println(person.toString());
        YamlWriter yamlWriter = new YamlWriter();
        yamlWriter.writeYaml(person, "src/main/resources/Person.yaml");
    }
}
