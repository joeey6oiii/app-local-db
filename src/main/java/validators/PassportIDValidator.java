package validators;

public class PassportIDValidator implements ValidateAble<String> {

    @Override
    public boolean validate(String passportID) {
        return passportID != null && passportID.length() >= 5;
    }
}
