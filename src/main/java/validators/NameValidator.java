package validators;

public class NameValidator implements ValidateAble<String> {

    @Override
    public boolean validate(String name) {
        return !(name == null || name.equals(""));
    }
}
