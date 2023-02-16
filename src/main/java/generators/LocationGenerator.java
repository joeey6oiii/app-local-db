package generators;

import defaultClasses.Location;

import java.util.Scanner;

public class LocationGenerator implements Generate{
    public Location generate(){
        Scanner scanner = new Scanner(System.in);
        Location location = new Location();
        System.out.print("Enter x (int): ");
        int x = scanner.nextInt();
        location.setX(x);
        System.out.print("Enter y (double): ");
        double y = scanner.nextDouble();
        location.setY(y);
        System.out.print("Enter z (int): ");
        int z = scanner.nextInt();
        location.setZ(z);
        String name = null;
        return location;
    }
}
