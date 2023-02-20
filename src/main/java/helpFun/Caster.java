package helpFun;

public class Caster {

    public static String castToSetter(String field) {
        return "set" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
    }

    public static String castToGetter(String field) {
        return "get" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
    }
}
