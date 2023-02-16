package defaultClasses;

import java.util.Objects;
import java.util.Scanner;

public class Coordinates implements Creatable{
    private int x;
    private float y;

    public Coordinates(){}

    public Coordinates(Integer x, Float y){
        this.x = x;
        this.y = y;
    }

    public Coordinates create(){
        Coordinates coordinates = new Coordinates();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x (int): ");
        int x = scanner.nextInt();
        coordinates.setX(x);
        System.out.print("Enter y (float): ");
        float y = scanner.nextFloat();
        coordinates.setY(y);
        return coordinates;
    };

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
