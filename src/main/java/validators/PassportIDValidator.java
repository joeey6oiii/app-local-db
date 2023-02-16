package validators;

import java.util.Objects;
import java.util.Scanner;

public class PassportIDValidator implements ValidateAble<String>{
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean validate(String passportID) {
        while (Objects.equals(passportID, "") ||
                passportID.length() < 4 || passportID.length() > 32){
            passportID = scanner.nextLine();
        }
        return true;
    }
}
