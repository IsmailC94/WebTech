

import java.io.Serializable;

public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String artikelGrpName;
	private Integer artikelGrpNr;
	
	public Integer getId() {
		return artikelGrpNr;
	}
	
	public void setId(Integer artikelGrpNr) {
		this.artikelGrpNr = artikelGrpNr;
	}
	
	public String getName() {
		return artikelGrpName;
	}
	
	public void setName(String artikelGrpName) {
		this.artikelGrpName = artikelGrpName;
	}
}