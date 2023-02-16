package validators;

import defaultClasses.Person;

public class PersonValidator implements ValidateAble<Person>{

    @Override
    public boolean validate(Person obj) {
        NameValidator nameValidator = new NameValidator();
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
        HeightValidator heightValidator = new HeightValidator();
        BirthdayValidator birthdayValidator = new BirthdayValidator();
        PassportIDValidator passportIDValidator = new PassportIDValidator();
        HairColorValidator hairColorValidator = new HairColorValidator();
        LocationValidator locationValidator = new LocationValidator();
        return nameValidator.validate(obj.getName()) && coordinatesValidator.validate(obj.getCoordinates())
                && heightValidator.validate(obj.getHeight()) && birthdayValidator.validate(obj.getBirthday())
                && passportIDValidator.validate(obj.getPassportID()) && hairColorValidator.validate(obj.getHairColor())
                && locationValidator.validate(obj.getLocation());
    }
}
