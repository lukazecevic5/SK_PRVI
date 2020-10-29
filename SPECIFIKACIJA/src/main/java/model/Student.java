package model;

import java.util.HashMap;

public class Student {

	private String id,ime,prezime,indeks;
	private Adresa adresa;
	
	private HashMap<String, String> simpleAtributes;
	private HashMap<String, Student> complexAtributes;
	
	public Student(String id, String ime, String prezime, String indeks, Adresa adresa) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.adresa = adresa;
		simpleAtributes = new HashMap<String, String>();
		complexAtributes = new HashMap<String, Student>();
	}
	
	public HashMap<String, Student> getComplexAtributes() {
		return complexAtributes;
	}
	public HashMap<String, String> getSimpleAtributes() {
		return simpleAtributes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	

	
}
