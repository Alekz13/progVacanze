package agenziaViaggi.dto;

import java.util.Objects;

public class MetaDto {
	private String citta, stato, continente;
	public MetaDto(String citta, String stato, String continente) {
		this.citta = citta;
		this.stato = stato;
		this.continente = continente;
	}
	public MetaDto() {
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(citta, continente, stato);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaDto other = (MetaDto) obj;
		return Objects.equals(citta, other.citta) && Objects.equals(continente, other.continente)
				&& Objects.equals(stato, other.stato);
	}
	@Override
	public String toString() {
		return "Meta [città=" + citta + ", stato=" + stato + ", continente=" + continente + "]";
	}
	
}
