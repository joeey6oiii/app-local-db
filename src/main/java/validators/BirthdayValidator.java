package validators;

import helpFun.StringToLocalDatetimeParser;

public class BirthdayValidator implements ValidateAble<String> {

    @Override
    public boolean validate(String birthday) {
        try {
            StringToLocalDatetimeParser.stringToLocalDateTime(birthday);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
