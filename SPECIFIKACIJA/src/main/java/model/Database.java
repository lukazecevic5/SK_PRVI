package model;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private static Database instance = null;
	private List<Entity> entities = new ArrayList<Entity>();
	
	private Database() {
		
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public void delEntity(int id) {
		for (Entity entity : entities) {
			if(entity.getId()==id) {
				entities.remove(entity);
			}
			
		}
	}
	
	public void updateEntity(int id) {
		for (Entity entity : entities) {
			if(entity.getId()==id) {
				int index = entities.indexOf(entity);
				
			}
		}
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	public static Database getInstance() {
		if(instance==null)
			instance = new Database();
		return instance;
	}
	
}
