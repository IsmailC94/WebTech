package edu.thi.uebung5.bean;

import java.io.Serializable;
import java.util.Date;

public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String anrede;
	private String vorname;
	private String nachname;
	private String strasse;
	private Integer plz;
	private Date proddate;
	private Date prodtime;
	private String benutzername;
	private String passwort;
	private String passwortWiederholung;
	
	
	
	public String getPasswortWiederholung() {
		return passwortWiederholung;
	}
	public void setPasswortWiederholung(String passwortWiederholung) {
		this.passwortWiederholung = passwortWiederholung;
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	public Date getProddate() {
		return proddate;
	}
	public void setProddate(Date proddate) {
	this.proddate = proddate;
	}
	public Date getProdtime() {
		return prodtime;
	}
	public void setProdtime(Date prodtime) {
		this.prodtime = prodtime;
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
