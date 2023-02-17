package validators;

public class PassportIDValidator implements ValidateAble<String>{

    @Override
    public boolean validate(String passportID) {
        if (passportID == null){
            return true;
        }
        return !(passportID.length() < 4 || passportID.length() > 32);
    }
}
