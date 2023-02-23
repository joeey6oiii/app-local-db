package defaultClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Color implements Generated {
    RED("red"),
    ORANGE("orange"),
    WHITE("white");

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
        if (Arrays.stream(Color.values()).anyMatch(e -> e.name().equalsIgnoreCase(colorName))) {
            return Arrays.stream(Color.values()).filter(e -> e.name().equalsIgnoreCase(colorName)).findAny().get();
        }
        else {
            System.out.println("\u001B[31m" + "Reassigned value:\u001B[0m \"hairColor="
                    + colorName + "\" -> \"hairColor=null\" for Person{id=" + Person.getIdentifier()
                    + "}. To change the value, please, type \"update " + Person.getIdentifier() +
                    " {hairColor}\" after the data is loaded");
        }
        return null;
    }
}