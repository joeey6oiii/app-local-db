package yamlsTools;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class YamlReader {
    // TODO(!): test disabled (or enabled) des. features
    // .configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false)
    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory())
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
            .findAndRegisterModules();

    public <T> List<T> readYaml(String yaml, Class<T> type) throws IOException, ClassNotFoundException {
        BufferedInputStream inputStream = (BufferedInputStream) type.getClassLoader().getResourceAsStream(yaml);
        Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + type.getName() + ";");
        T[] objects = objectMapper.readValue(inputStream, arrayClass);
        return Arrays.asList(objects);
    }
}