package impl;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ImportExportJSON {

//    
    public List<Object> importFileToObject(String path) throws Exception
    {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> entiteti = objectMapper.readValue(new File(path), new TypeReference<List<Object>>() {
        });

       return entiteti;
    }

    public boolean exportObjectToFile(List<Object> entiteti, String path) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), entiteti);



        return true;
    }

}