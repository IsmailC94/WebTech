package beans;

import java.io.Serializable;

public class Pordukte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int artikelgruppe;
	private String produktname;
	private Double produktpreis;
	private int menge;
	private String bildpfad;
	private Long id;
	
	public int getArtikelgruppe() {
		return artikelgruppe;
	}
	public void setArtikelgruppe(int artikelgruppe) {
		this.artikelgruppe = artikelgruppe;
	}
	public String getProduktname() {
		return produktname;
	}
	public void setProduktname(String produktname) {
		this.produktname = produktname;
	}
	public Double getProduktpreis() {
		return produktpreis;
	}
	public void setProduktpreis(Double produktpreis) {
		this.produktpreis = produktpreis;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
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
