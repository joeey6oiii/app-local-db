package defaultClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Color {
    GREEN("green"),
    RED("red"),
    ORANGE("orange"),
    WHITE("white"),
    BROWN("brown"),
    BLACK("black");

    private final String colorName;

    private final static Map<String, Color> colors = Arrays.stream(Color.values()).collect(Collectors.toMap(k->k.colorName, v->v));

    Color(String colorName){
        this.colorName = colorName;
    }

    public static ArrayList<Color> listValues(){
        return new ArrayList<>(Arrays.asList(Color.values()));
    }

    public static Color getColorByName (String colorName){
        return colors.get(colorName);
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    static Color findValue(@JsonProperty("colorName") String colorName) {
        if (Arrays.stream(Color.values()).anyMatch(pt -> pt.colorName.equals(colorName))) {
            return Arrays.stream(Color.values()).filter(pt -> pt.colorName.equals(colorName)).findFirst().get();
        }
        return null;
    }
}