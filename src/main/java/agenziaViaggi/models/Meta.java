package agenziaViaggi.models;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mete")
public class Meta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String citta, stato, continente;
	public Meta(String citta, String stato, String continente) {
		this.citta = citta;
		this.stato = stato;
		this.continente = continente;
	}
	public Meta() {
		// TODO Auto-generated constructor stub
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
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(citta, continente, id, stato);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meta other = (Meta) obj;
		return Objects.equals(citta, other.citta) && Objects.equals(continente, other.continente) && id == other.id
				&& Objects.equals(stato, other.stato);
	}
	@Override
	public String toString() {
		return "Meta [id=" + id + ", citta=" + citta + ", stato=" + stato + ", continente=" + continente + "]";
	}
	
	
}
