package validators;

import java.util.Scanner;

public class NameValidator implements ValidateAble<String>{
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean validate(String name) {
        while (name == null || name.equals("")){
            name = scanner.nextLine();
        }
        return true;
    }
}
