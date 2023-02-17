package generators;

import defaultClasses.Coordinates;

import java.util.Scanner;

public class CoordinatesGenerator implements Generate {
    public Coordinates generate() {
        try {
            Coordinates coordinates = new Coordinates();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter x (int) \n$ ");
            int x = scanner.nextInt();
            coordinates.setX(x);
            System.out.print("Enter y (float) \n$ ");
            float y = scanner.nextFloat();
            coordinates.setY(y);
            return coordinates;
        } catch (Exception e){
            return null;
        }
    }

}
