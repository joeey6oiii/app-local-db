package yamlsTools;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YamlReader {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final Scanner scanner = new Scanner(System.in);
    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory())
            .configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true)
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
            .findAndRegisterModules();

    public <T> List<T> readYaml(String yaml, Class<T> type) throws ClassNotFoundException {
        Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + type.getName() + ";");
        T[] objects = null;
        try {
            BufferedInputStream inputStream = (BufferedInputStream) type.getClassLoader().getResourceAsStream(yaml);
            objects = objectMapper.readValue(inputStream, arrayClass);
        } catch (Exception e) {
            System.out.println("Invalid path or the file is damaged: " + ANSI_RED + e.getMessage() + ANSI_RESET);
            System.out.print("Would you like to change the path?" +
                    " Type [Y/N] (N automatically terminates the program) \n$ ");
            String decision = scanner.nextLine();
            while(!decision.equalsIgnoreCase("Y") && !decision.equalsIgnoreCase("N")) {
                decision = scanner.nextLine();
            }
            if (decision.equalsIgnoreCase("N")) {
                System.out.println("Program has been successfully terminated");
                System.exit(0);
            }
            else {
                boolean isPath = false;
                System.out.print("Enter path to continue program execution or [N] to terminate the program \n$ ");
                do {
                    try {
                        yaml = scanner.nextLine();
                        if (yaml.equalsIgnoreCase("N")) {
                            System.out.println("Program has been successfully terminated");
                            System.exit(0);
                        }
                        BufferedInputStream inputStream = (BufferedInputStream) type.getClassLoader().getResourceAsStream(yaml);
                        objects = objectMapper.readValue(inputStream, arrayClass);
                        isPath = true;
                    } catch (Exception exception) {
                        System.out.println("Invalid value: " + ANSI_RED + exception.getMessage() + ANSI_RESET);
                        System.out.print("Enter path to continue program execution or [N] to terminate the program \n$ ");
                    }
                } while (!isPath);
            }
        }
        return Arrays.asList(objects);
    }
}