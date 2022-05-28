

import java.io.Serializable;

public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer posNr;
	private Long bestellNr;
	private Integer produktNr;
	private Integer menge;
	private Double posPreis;
	
	public Integer getId() {
		return posNr;
	}
	
	public void setId(Integer posNr) {
		this.posNr = posNr;
	}
	
	public Long getBestellNr() {
		return bestellNr;
	}
	
	public void setBestellNr(Long bestellNr) {
		this.bestellNr = bestellNr;
	}
	
	public Integer getProNr() {
		return produktNr;
	}
	
	public void setProNr(Integer produktNr) {
		this.produktNr = produktNr;
	}
	
	public Integer getMenge() {
		return menge;
	}
	
	public void setMenge(Integer menge) {
		this.menge = menge;
	}
	
	public Double getPosPreis() {
		return posPreis;
	}
	
	public void setPosPreis(Double posPreis) {
		this.posPreis = posPreis;
	}
}