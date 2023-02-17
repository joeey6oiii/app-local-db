package validators;

import defaultClasses.Person;

public class PersonValidator implements ValidateAble<Person>{
    private final NameValidator nameValidator = new NameValidator();
    private final CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
    private final HeightValidator heightValidator = new HeightValidator();
    private final PassportIDValidator passportIDValidator = new PassportIDValidator();
    private final LocationValidator locationValidator = new LocationValidator();

    public NameValidator getNameValidator(){
        return nameValidator;
    }

    public CoordinatesValidator getCoordinatesValidator(){
        return coordinatesValidator;
    }

    public HeightValidator getHeightValidator() {
        return heightValidator;
    }

    public PassportIDValidator getPassportIDValidator() {
        return passportIDValidator;
    }

    public LocationValidator getLocationValidator() {
        return locationValidator;
    }

    @Override
    public boolean validate(Person obj) {
        return nameValidator.validate(obj.getName()) && coordinatesValidator.validate(obj.getCoordinates())
                && heightValidator.validate(obj.getHeight()) && passportIDValidator.validate(obj.getPassportID())
                && locationValidator.validate(obj.getLocation());
    }
}