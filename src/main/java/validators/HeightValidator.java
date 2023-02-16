package validators;

import java.util.Scanner;

public class HeightValidator implements ValidateAble<Long>{
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean validate(Long height) {
        while (height == null || height <= 0){
            height = scanner.nextLong();
        }
        return true;
    }
}
