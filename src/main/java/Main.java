import defaultClasses.Color;
import defaultClasses.Coordinates;
import defaultClasses.Person;
import yamlsTools.YamlReader;
import yamlsTools.YamlWriter;


import java.io.IOException;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Alexey", new Coordinates(1, 3.0f),
                2L, LocalDateTime.now(), "78910", null, null);
        Person person2 = new Person("Dmitry", new Coordinates(2, 2.0f),
                3L, LocalDateTime.now(), "123456", Color.BROWN, null);
//        System.out.println(person.getId());
//        String path = System.getenv("Lab5");
//        System.out.println(path);
//        System.out.println(person.toString());
//        YamlWriter yamlWriter = new YamlWriter();
//        yamlWriter.writeYaml(person, "src/main/resources/Person.yaml");
//        yamlWriter.writeYaml(person2, "src/main/resources/Person.yaml");
        YamlReader yamlReader = new YamlReader();
        System.out.println(yamlReader.readYaml("Person.yaml", Person.class));
        Person person3 = new Person();
        person3 = person2.create();
        System.out.println(person3.toString());
    }
}
