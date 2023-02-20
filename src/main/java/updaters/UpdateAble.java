package updaters;

import defaultClasses.IsUpdateable;

@FunctionalInterface
public interface UpdateAble<T extends IsUpdateable > {
    void update(T isUpdateable);
}
