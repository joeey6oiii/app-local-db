package helpFun;

import java.lang.reflect.InvocationTargetException;

public class Reflection {

    public static Object getValue(Object object, String field) {
        field = Caster.castToGetter(field); Object previous_value = null;
        try {
            previous_value = object.getClass().getMethod(field).invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return previous_value;
    }

    public static void setValue(Object object, String field, Class<?> fieldClass, Object parameter) {
        field = Caster.castToSetter(field);
        try {
            object.getClass().getMethod(field, fieldClass).invoke(object, parameter);
        } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}