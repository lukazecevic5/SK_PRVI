package model;

public class Adresa {
	String ulica,grad,drzava;
	int broj;
	
	
	public Adresa(String ulica, String grad, String drzava, int broj) {
		this.ulica = ulica;
		this.grad = grad;
		this.drzava = drzava;
		this.broj = broj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	
	
}
