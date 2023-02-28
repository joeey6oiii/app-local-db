package helpFun;

/**
 * A class with help caster methods.
 *
 * @see Reflection
 */

public class Caster {

    /**
     * @param field field name
     * @return setter with the specified field name. Example: entering "name" will return "setName"
     */

    public static String castToSetter(String field) {
        return "set" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
    }

    /**
     * @param field field name
     * @return getter with the specified field name. Example: entering "coordinates" will return "getCoordinates"
     */

    public static String castToGetter(String field) {
        return "get" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
    }
}
