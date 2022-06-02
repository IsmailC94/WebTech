package edu.thi.uebung5.bean;

import java.io.Serializable;


public class KundeRegistration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String anrede;
	private String vorname;
	private String nachname;
	private String strasse;
	private Integer plz;


	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	public Integer getPlz() {
		return plz;
	}
	public void setPlz(Integer plz) {
		this.plz = plz;
	}
	private String ort;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
	
	
}
