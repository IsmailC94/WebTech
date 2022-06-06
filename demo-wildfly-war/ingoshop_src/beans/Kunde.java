package beans;

import java.io.Serializable;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.Servlet;

public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String passwort;
	private String eMail;
	private String geschlecht;
	private java.sql.Date geburtsdatum;
	private String plz;
	private String ort;
	private String hausnummer;
	private String strasse;
	private String vorname;
	private String FamName;
	private int admin;
	
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public java.sql.Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(java.sql.Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getFamName() {
		return FamName;
	}
	public void setFamName(String nachname) {
		this.FamName = nachname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}