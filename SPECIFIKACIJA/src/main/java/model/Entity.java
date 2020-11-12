package model;

import java.util.HashMap;
import java.util.Map;


public class Entity {

	private int id;
	private String naziv;
	
	private Map<String, String> simpleProperties;
	private Map<String, Entity> entityProperties;
	
	public Entity(int id,String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
		simpleProperties = new HashMap<String, String>();
		entityProperties = new HashMap<String, Entity>();
	}
	
	public Entity() {
		simpleProperties = new HashMap<String, String>();
		entityProperties = new HashMap<String, Entity>();
	}
	
	public void addEntityProperties(String key,Entity value) {
		entityProperties.put(key, value);
	}
	public Map<String, Entity> getEntityProperties() {
		return entityProperties;
	}
	public void setEntityProperties(Map<String, Entity> entityAtributes) {
		this.entityProperties = entityAtributes;
	}
	public Map<String, String> getSimpleProperties() {
		return simpleProperties;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	} 

	public void setSimpleProperties(Map<String, String> atributes) {
		this.simpleProperties = atributes;
	}
	
	public void addSimpleProperties(String key,String value) {
		simpleProperties.put(key, value);
	}
	@Override
	public String toString() {
		return "Entitet [id=" + id + ", naziv=" + naziv + ", simpleProperties=" + simpleProperties
				+ ", entityProperties=" + entityProperties + "]";
	}
	
}
