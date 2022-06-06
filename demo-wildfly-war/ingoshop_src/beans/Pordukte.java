package beans;

import java.io.Serializable;

public class Pordukte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String artikelgruppe;
	private String produktname;
	private String produktpreis;
	private String menge;
	private String bildpfad;
	private Long id;
	
	public String getArtikelgruppe() {
		return artikelgruppe;
	}
	public void setArtikelgruppe(String artikelgruppe) {
		this.artikelgruppe = artikelgruppe;
	}
	public String getProduktname() {
		return produktname;
	}
	public void setProduktname(String produktname) {
		this.produktname = produktname;
	}
	public String getProduktpreis() {
		return produktpreis;
	}
	public void setProduktpreis(String produktpreis) {
		this.produktpreis = produktpreis;
	}
	public String getMenge() {
		return menge;
	}
	public void setMenge(String menge) {
		this.menge = menge;
	}
	public String getBildpfad() {
		return bildpfad;
	}
	public void setBildpfad(String bildpfad) {
		this.bildpfad = bildpfad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
