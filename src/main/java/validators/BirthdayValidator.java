package validators;

import java.time.LocalDateTime;

public class BirthdayValidator implements ValidateAble<LocalDateTime> {

    @Override
    public boolean validate(LocalDateTime birthday) {
        return birthday != null;
    }
}
