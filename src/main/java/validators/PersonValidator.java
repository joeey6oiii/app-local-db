package validators;

import defaultClasses.Person;

public class PersonValidator implements ValidateAble<Person> {

    @Override
    public boolean validate(Person person) {
        return  new NameValidator().validate(person.getName())
                && new HairColorValidator().validate(person.getHairColor())
                && new CoordinatesValidator().validate(person.getCoordinates())
                && new HeightValidator().validate(person.getHeight())
                && new BirthdayValidator().validate(person.getBirthday())
                && new PassportIDValidator().validate(person.getPassportID())
                && new LocationValidator().validate(person.getLocation());
    }
}