package generators;

import defaultClasses.Coordinates;

import java.util.Scanner;

public class CoordinatesGenerator implements Generate {
    public Coordinates generate() {
        try {
            Coordinates coordinates = new Coordinates();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter x (long) \n$ ");
            long x = Long.parseLong(scanner.nextLine());
            coordinates.setX(x);
            System.out.print("Enter y (int) \n$ ");
            int y = Integer.parseInt(scanner.nextLine());
            coordinates.setY(y);
            return coordinates;
        } catch (Exception e){
            return null;
        }
    }

}
