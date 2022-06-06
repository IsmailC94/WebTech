package beans;

import java.io.Serializable;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.Servlet;

public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int artikelgruppe;
	private String produktname;
	private Double produktpreis;
	private int menge;
	private String bildpfad;
	private Long id;
	
	//getters
	
	public int getArtikelgruppe() {
		return artikelgruppe;
	}
	
	public String getProduktname() {
		return produktname;
	}
	
	public Double getProduktPreis() {
		return produktpreis;
	}
	
	public Integer getMenge() {
		return menge;
	}
	
	public String getBildPfad() {
		return bildpfad;
	}
	
	public Long getId() {
		return id;
	}
	
	//setters
	
	public void setArtikelgruppe(int artikelgruppe)
	{
		this.artikelgruppe = artikelgruppe;
	}
	
	public void setProduktname(String produktname)
	{
		this.produktname=produktname;
	}
	
	public void setProduktPreis(Double produktpreis)
	{
		this.produktpreis=produktpreis;
	}
	
	public void setMenge(int menge)
	{
		this.menge = menge;
	}
	public void setMenge(String bildpfad)
	{
		this.bildpfad=bildpfad;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
