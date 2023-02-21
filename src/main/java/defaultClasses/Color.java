package defaultClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import helpFun.SystemNotification;

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
            SystemNotification.notification("REASSIGNED VALUE: \"hairColor=" + colorName
                    + "\" -> \"hairColor=null\" FOR Person{id=" + Person.getIdentifier()
                    + "}. TO CHANGE THE VALUE, PLEASE, TYPE \"update " + Person.getIdentifier() + " {hairColor}\"" +
                    " AFTER DATA UPLOADING FINISHES");
        }
        return null;
    }
}