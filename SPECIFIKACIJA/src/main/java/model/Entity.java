package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {

	private int id;
	private String naziv;
	
	private Map<String, Object> simpleAtributes;
	
	private Map<String,Entity> entityAtributes;
	
	public Entity(int id,String naziv) {
		this.id = id;
		this.naziv = naziv;
		simpleAtributes = new HashMap<String, Object>();
		entityAtributes = new HashMap<String, Entity>();
	}
	
	public void addEntityAtribute(String key,Entity value) {
		entityAtributes.put(key, value);
	}
	public Map<String, Entity> getEntityAtributes() {
		return entityAtributes;
	}
	public void setEntityAtributes(Map<String, Entity> entityAtributes) {
		this.entityAtributes = entityAtributes;
	}
	
	public Entity() {
		simpleAtributes = new HashMap<String, Object>();
		entityAtributes = new HashMap<String, Entity>();
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

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Map<String, Object> getSimpleAtributes() {
		return simpleAtributes;
	}

	public void setSimpleAtributes(Map<String, Object> atributes) {
		this.simpleAtributes = atributes;
	}
	
	public void addSimpleAtributes(String key,Object value) {
		simpleAtributes.put(key, value);
	}
	
	
}
