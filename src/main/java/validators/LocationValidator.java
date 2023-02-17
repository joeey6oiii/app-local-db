package validators;

import defaultClasses.Location;

import java.util.Scanner;

public class LocationValidator implements ValidateAble<Location> {
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean validate(Location location) {
        if (location != null) {
            while (location.getY() == null) {
                location = new Location();
                Double y = scanner.nextDouble();
                location.setY(y);
                // TODO
            }
        }
        return true;
    }
}
