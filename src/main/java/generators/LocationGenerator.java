package generators;

import defaultClasses.Location;

import java.util.Objects;
import java.util.Scanner;

public class LocationGenerator implements Generate {
    public Location generate() {
        Scanner scanner = new Scanner(System.in);
        Location location = new Location();
        try {
            System.out.print("Enter x (int) \n$ ");
            int x = Integer.parseInt(scanner.nextLine());
            location.setX(x);
            System.out.print("Enter y (double) \n$ ");
            double y = Double.parseDouble(scanner.nextLine());
            location.setY(y);
            System.out.print("Enter z (int) \n$ ");
            int z = Integer.parseInt(scanner.nextLine());
            location.setZ(z);
            System.out.print("Enter name \n$ ");
            String name = scanner.nextLine();
            if (Objects.equals(name, "")) {
                location.setName(null);
            } else {
                location.setName(name);
            }
            return location;
        } catch (Exception e) {
            return null;
        }
    }
}
