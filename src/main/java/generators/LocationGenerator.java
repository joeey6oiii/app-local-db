package generators;

import defaultClasses.Location;

import java.util.Scanner;

public class LocationGenerator implements Generate {
    public Location generate() {
        Scanner scanner = new Scanner(System.in);
        Location location = new Location();
        try {
            System.out.print("Enter x (int) \n$ ");
            int x = scanner.nextInt();
            location.setX(x);
            System.out.print("Enter y (double) \n$ ");
            double y = scanner.nextDouble();
            location.setY(y);
            System.out.print("Enter z (int) \n$ ");
            int z = scanner.nextInt();
            location.setZ(z);
            String name = null;
            return location;
        } catch (Exception e) {
            return null;
        }
    }
}
