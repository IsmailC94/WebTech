

import java.io.Serializable;

public class Bestellung implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long bestellNr;
	private String kundenNr;
	private Double gesamtPreis;
	
	public Long getId() {
		return bestellNr;
	}
	
	public void setId(Long bestellNr) {
		this.bestellNr = bestellNr;
	}
	
	public String getKundenNr() {
		return kundenNr;
	}
	
	public void setKundenNr(String kundenNr) {
		this.kundenNr = kundenNr;
	}
	
	public Double getGPreis() {
		return gesamtPreis;
	}
	
	public void setGPreis(Double gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}
}