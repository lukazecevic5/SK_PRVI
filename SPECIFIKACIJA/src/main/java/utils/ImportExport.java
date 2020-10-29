package utils;

public interface ImportExport {
	Object importFileToObject(String path, Class<?> classOf);

	boolean exportObjectToFile(Object obj, String path);
}
