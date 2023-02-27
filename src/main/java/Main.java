import commands.*;
import dataBase.*;
import defaultClasses.*;
import yamlsTools.*;

import java.util.*;

/**
 * Program entry point class. Contains <code>main()</code> method.
 * <p>
 * The program manages a {@link Person} collection of type <code>HashSet</code>
 *
 * @see DataBase
 */

public class Main {

    /**
     * Program entry point.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        System.out.println("\u001B[33m---Welcome to the Person" +
                " database console application---\u001B[0m");

        System.out.print("\nInput path to the file\n$ ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Loader loader = new Loader();
        loader.assertToken();

        Class<Person> type = Person.class;
        YAMLReader yamlReader = new YAMLReader();
        List<Person> list = yamlReader.read(path, type);
        loader.load(GlobalObj.dataBase, list);

        CommandManager commandManager = new CommandManager();
        commandManager.startWorking();
    }
}