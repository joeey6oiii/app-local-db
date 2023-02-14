package yamlsTools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class YamlReader {
    public <T> T readYaml(String path, Class<T> type) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        T object_collection = null;
        try {
            object_collection = mapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object_collection;
    }
}
