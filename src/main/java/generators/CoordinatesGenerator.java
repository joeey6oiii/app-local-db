package generators;

import defaultClasses.Coordinates;

import java.util.Scanner;

public class CoordinatesGenerator implements Generate{
    public Coordinates generate(){
        Coordinates coordinates = new Coordinates();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x (int): ");
        int x = scanner.nextInt();
        coordinates.setX(x);
        System.out.print("Enter y (float): ");
        float y = scanner.nextFloat();
        coordinates.setY(y);
        return coordinates;
    };
}
