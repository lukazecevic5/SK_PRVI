package model;

import java.util.HashMap;

public class Entity {

	private int id;
	private String naziv;
	
	private HashMap<String, Object> atributes;
	
	public Entity(int id,String naziv) {
		this.id = id;
		this.naziv = naziv;
		atributes = new HashMap<String, Object>();
	}
	
	public Entity() {
		atributes = new HashMap<String, Object>();
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

	public HashMap<String, Object> getAtributes() {
		return atributes;
	}

	public void setAtributes(HashMap<String, Object> atributes) {
		this.atributes = atributes;
	}
	
	public void addAtributes(String key,Object value) {
		atributes.put(key, value);
	}

	
}
