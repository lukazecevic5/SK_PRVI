package impl;

import java.util.List;

import model.Entity;

public class testiranje {

	public static void main(String[] args) throws Exception{
		ImportExportJSON imp = new ImportExportJSON();
		List<Entity> list = imp.importFileToObject("data/data.json");
		
		for(Entity e : list) {
			System.out.println(e);
		}
	}

}
