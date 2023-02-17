package yamlsTools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.BufferedInputStream;
import java.io.IOException;

public class YamlReader {
    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    public <T> T readYaml(String path, Class<T> type) throws IOException {
        BufferedInputStream inputStream = (BufferedInputStream) type.getClassLoader().getResourceAsStream(path);
        this.objectMapper.findAndRegisterModules();
        return this.objectMapper.readValue(inputStream, type);
    }
}