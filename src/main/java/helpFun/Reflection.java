package helpFun;

import java.lang.reflect.InvocationTargetException;

/**
 * A class that allows to interact with object fields using <code>java.lang.reflect</code>.
 *
 * @see Caster
 */

public class Reflection {

    /**
     * Acts like a getter method.
     *
     * @param object the object with whose fields to interact
     * @param field the name of the field to interact with
     * @return the value of the specified field
     */

    public static Object getValue(Object object, String field) {
        field = Caster.castToGetter(field); Object value = null;
        try {
            value = object.getClass().getMethod(field).invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Acts like a setter method.
     *
     * @param object the object with whose fields to interact
     * @param field the name of the field to interact with
     * @param fieldClass the class of the field name
     * @param parameter the value to set
     */

    public static void setValue(Object object, String field, Class<?> fieldClass, Object parameter) {
        field = Caster.castToSetter(field);
        try {
            object.getClass().getMethod(field, fieldClass).invoke(object, parameter);
        } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}