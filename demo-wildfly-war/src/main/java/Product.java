

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long ProduktNr;
	private String productname;
	private Double Produktpreis;
	private Integer ArtikelGrp;
	
	public Long getId() {
		return ProduktNr;
	}
	
	public void setId(Long ProduktNr) {
		this.ProduktNr = ProduktNr;		
	}
	
	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public Double getPreis() {
		return Produktpreis;
	}
	
	public void getPreis(Double Produktpreis) {
		this.Produktpreis = Produktpreis;
	}
	
	public Integer getArtikelGrp() {
		return ArtikelGrp;
	}
	
	public void setArtikelGrp(Integer ArtikelGrp) {
		this.ArtikelGrp = ArtikelGrp;
	}
}