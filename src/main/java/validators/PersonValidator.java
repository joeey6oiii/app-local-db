package validators;

import defaultClasses.Person;

public class PersonValidator implements ValidateAble<Person> {
    private final NameValidator nameValidator = new NameValidator();
    private final CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
    private final HeightValidator heightValidator = new HeightValidator();
    private final BirthdayValidator birthdayValidator = new BirthdayValidator();
    private final PassportIDValidator passportIDValidator = new PassportIDValidator();
    private final LocationValidator locationValidator = new LocationValidator();

    public BirthdayValidator getBirthdayValidator(){
        return birthdayValidator;
    }

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
    public boolean validate(Person person) {
        return  nameValidator.validate(person.getName()) && coordinatesValidator.validate(person.getCoordinates())
                && heightValidator.validate(person.getHeight()) && birthdayValidator.validate(person.getBirthday())
                && passportIDValidator.validate(person.getPassportID()) && locationValidator.validate(person.getLocation());
    }
}