package impl;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Entity;



public class ImportExportJSON {

//    
    public List<Entity> importFileToObject(String path) throws Exception
    {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Entity> entiteti = objectMapper.readValue(new File(path), new TypeReference<List<Entity>>() {
        });

       return entiteti;
    }

    
    public boolean exportObjectToFile(List<Entity> entiteti, String path) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), entiteti);



        return true;
    }

}