package edu.thi.demo;

import java.io.Serializable;

public class ErstelleKundeBean {
	private static final long serialVersionUID = 1L;

	private String email;
	private String geschlecht;
	private String gebDatum;
	private String plz;
	private String ort;
	private Integer hausNr;
	private String strasse;
	private String vorname;
	private String famName;
	private Integer kundenNr;
	private String passwort;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email1)	{
		this.email=email1;
	}
	
	public String getGeschl() {
		return geschlecht;
	}
	
	public void setGeschl(String geschlecht) {
		this.geschlecht=geschlecht;
	}
	
	public String getGebDatum() {
		return gebDatum;
	}
	
	public void setGebDatum(String gebDatum) {
		this.gebDatum=gebDatum;
	}
	
	public String getPLZ() {
		return plz;
	}
	
	public void setPLZ(String plz) {
		this.plz=plz;
	}
	
	public String getOrt() {
		return ort;
	}
	
	public void setOrt(String ort) {
		this.ort=ort;
	}
	
	public Integer getHausNr() {
		return hausNr;
	}
	
	public void setHausNr(Integer hausNr) {
		this.hausNr=hausNr;
	}
	
	public String getStr() {
		return strasse;
	}
	
	public void setStr(String strasse) {
		this.strasse=strasse;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname=vorname;
	}
	
	public String getFamName() {
		return famName;
	}
	
	public void setFamName(String famName) {
		this.famName=famName;
	}
	
	public Integer getKdNr() {
		return kundenNr;
	}
	
	public void setKdNr(Integer kundenNr) {
		this.kundenNr=kundenNr;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public void setPasswort(String passwort) {
		this.passwort=passwort;
	}
}