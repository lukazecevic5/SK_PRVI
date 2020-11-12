package yml;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

import model.Entity;

//test
//object == entity
class ImportExportYaml {

    public List<Entity> importFileToObject(String path) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        List<Entity> entiteti = objectMapper.readValue(new File(path), new TypeReference<List<Entity>>() {
        });

        return entiteti;
    }
    boolean exportObjectToFile(List<Object> entiteti, String path) throws Exception{
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
        String yaml = mapper.writeValueAsString(entiteti);
        stringToFile(path, yaml);

        return true;
    }
    private void stringToFile(String destinationPath, String data) {
        File file = new File("");
        // file = new File(file.getAbsolutePath() + destinationPath);
        file = new File(destinationPath);
        file.setWritable(true);

        try (FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            // convert string to byte array
            byte[] bytes = data.getBytes();
            // write byte array to file
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.print("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}