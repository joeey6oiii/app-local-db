package validators;

public class HeightValidator implements ValidateAble<Long> {

    @Override
    public boolean validate(Long height) {
        return !(height == null || height <= 0);
    }
}