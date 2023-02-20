package generators;

import defaultClasses.Color;
import defaultClasses.Generated;

import java.util.Scanner;

public class ColorGenerator implements Generate {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Generated generate() {
        System.out.println("Available colors: " + Color.listValues());
        System.out.print("Input color: Color (nullable) \n$ ");
        return Color.getColorByName(scanner.nextLine());
    }
}
