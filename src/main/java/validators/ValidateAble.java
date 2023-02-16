package validators;
@FunctionalInterface
public interface ValidateAble<T> {
    boolean validate(T obj);
}
