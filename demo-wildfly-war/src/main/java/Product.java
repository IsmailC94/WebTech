

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long produktNr;
	private String productname;
	private Double preis;
	private Integer ArtikelGrp;
	private Integer Menge;
	
	public Long getId() {
		return produktNr;
	}
	
	public void setId(Long produktNr) {
		this.produktNr = produktNr;		
	}
	
	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public Double getPreis() {
		return preis;
	}
	
	public void setPreis(Double preis) {
		this.preis = preis;
	}
	
	public Integer getArtikelGrp() {
		return ArtikelGrp;
	}
	
	public void setArtikelGrp(Integer ArtikelGrp) {
		this.ArtikelGrp = ArtikelGrp;
	}
	
	public Integer getMenge() {
		return Menge;
	}
	
	public void setMenge(Integer Menge) {
		this.Menge = Menge;
	}
}