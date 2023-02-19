package validators;

import defaultClasses.Location;

import java.util.Objects;

public class LocationValidator implements ValidateAble<Location> {

    @Override
    public boolean validate(Location location) {
        if (location != null) {
            return !(location.getY() == null) && !Objects.equals(location.getName(), "");
        }
        return true;
    }
}