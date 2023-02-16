package yamlsTools;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.*;

public class YamlWriter {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    public void writeYaml(Object object, String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.mapper.writeValue(file, object);
    }
}
