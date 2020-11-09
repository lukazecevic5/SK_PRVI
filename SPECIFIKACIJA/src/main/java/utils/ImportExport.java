package utils;

import java.util.List;

import model.Entity;

public interface ImportExport {
	List<Entity> importFileToObject(String path) throws Exception;

	boolean exportObjectToFile(List<Entity> entities, String path);
}
