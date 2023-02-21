package validators;

import defaultClasses.Coordinates;

public class CoordinatesValidator implements ValidateAble<Coordinates> {

    @Override
    public boolean validate(Coordinates coordinates) {
        return coordinates != null;
    }
}
