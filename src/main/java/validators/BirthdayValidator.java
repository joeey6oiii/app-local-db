package validators;

import java.util.Date;

public class BirthdayValidator implements ValidateAble<Date> {

    @Override
    public boolean validate(Date birthday) {
        return birthday != null;
    }
}
