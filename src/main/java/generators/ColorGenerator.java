package generators;

import defaultClasses.Color;
import defaultClasses.Generated;

import java.util.Scanner;

public class ColorGenerator implements Generate {

    @Override
    public Generated generate() {
        System.out.print("Available colors: " + Color.listValues() + "\nInput color: Color (nullable)\n$ ");
        return Color.getColorByName(new Scanner(System.in).nextLine());
    }
}
