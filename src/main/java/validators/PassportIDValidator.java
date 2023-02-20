package validators;

import java.util.Objects;

public class PassportIDValidator implements ValidateAble<String> {

    @Override
    public boolean validate(String passportID) {
        return passportID != null && !Objects.equals(passportID, "")
                && !(passportID.length() < 4 || passportID.length() > 32);
    }
}
