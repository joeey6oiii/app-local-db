package validators;

import defaultClasses.Coordinates;

import java.util.Scanner;

public class CoordinatesValidator implements ValidateAble<Coordinates>{
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean validate(Coordinates coordinates) {
        boolean delete;
        while (coordinates == null) {
            Coordinates creation = new Coordinates();
            // TODO: ask to create coordinates or delete object
        }
        while (coordinates.getX() == null) {
            Integer x = scanner.nextInt();
            coordinates.setX(x);
            // TODO: check input
        }
        while (coordinates.getY() == null) {
            Float y = scanner.nextFloat();
            coordinates.setY(y);
            // TODO: check input
        }
        return true;
    }
}
