package validators;

import defaultClasses.Color;

public class HairColorValidator implements ValidateAble<Color> {

    @Override
    public boolean validate(Color color) {
        if (color == null) {
            return true;
        }
        return Color.listValues().contains(color);
    }
}
