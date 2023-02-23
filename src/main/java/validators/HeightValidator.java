package validators;

public class HeightValidator implements ValidateAble<Integer> {

    @Override
    public boolean validate(Integer height) {
        return height > 0;
    }
}
