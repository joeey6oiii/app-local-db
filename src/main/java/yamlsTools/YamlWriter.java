package yamlsTools;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//import com.fasterxml.jackson.datatype.jsr310.*;

/**
 * A class that implements the save command, it saves the collection to a file along the path src/main/resources/orderOutput.yaml
 *
 * @autor Dmitrii Chebanenko
 */
public class YamlWriter {
    /**
     * Method that saves collection to a file along the path src/main/resources/orderOutput.yaml
     *
     * @param object - object that is saved to a file
     * @throws IOException - the method throws an exception if the input of the object parameter fails
     */
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();
    public void writeYaml(Object object) throws IOException {
        File file = new File("src/main/resources/orderOutput.yaml");
        if(file.createNewFile()){
            System.out.println("File created");
        }
        else{
            System.out.println("File already exists");
        }
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.mapper.writeValue(file, object);
    }
}