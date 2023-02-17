package validators;

import defaultClasses.Location;

public class LocationValidator implements ValidateAble<Location> {

    @Override
    public boolean validate(Location location) {
        if (location != null) {
            return !(location.getY() == null);
        }
        return true;
    }
}