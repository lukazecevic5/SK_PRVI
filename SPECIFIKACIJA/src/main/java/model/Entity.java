package model;

import java.util.HashMap;

public class Entity {

	private int id;
	private String naziv;
	
	private HashMap<String, Entity> atributes;
	
	public Entity(int id,String naziv) {
		this.id = id;
		this.naziv = naziv;
		atributes = new HashMap<String, Entity>();
	}
	
	public HashMap<String, Entity> atributes() {
		return atributes;
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

	public HashMap<String, Entity> getAtributes() {
		return atributes;
	}

	public void setAtributes(HashMap<String, Entity> atributes) {
		this.atributes = atributes;
	}
	
	

	
}
