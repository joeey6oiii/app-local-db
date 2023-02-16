package defaultClasses;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Color {
    GREEN("green"),
    RED("red"),
    ORANGE("orange"),
    WHITE("white"),
    BROWN("brown"),
    BLACK("black");

    private final String colorName;
    private final static Map<String, Color> colors = Arrays.stream(Color.values()).collect(Collectors.toMap(k->k.colorName, v->v));

    private Color(String colorName){
        this.colorName = colorName;
    }

    public static void showColor(){
        int i = 0;
        for (Color col: Color.values()){
            i++;
            System.out.println(i + " - " + col);
        }
    }
    public static Color[] arrayOfTheColors(){
        return Color.values();
    }

    public static Color getColorByName (String colorName){
        return colors.get(colorName);
    }
}
