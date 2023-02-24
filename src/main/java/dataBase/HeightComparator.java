package dataBase;

import defaultClasses.Person;

import java.util.Comparator;

public class HeightComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        return Integer.compare(p1.getHeight(), p2.getHeight());
    }
}
