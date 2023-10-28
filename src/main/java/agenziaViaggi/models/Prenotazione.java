package agenziaViaggi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazione {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id_prenotazione")
private long id;
private int numPartecipanti;
@ManyToOne
@JoinColumn(name = "id_utente")
private Utente utente;
@ManyToOne
@JoinColumn(name = "id_pacchetto")
private Pacchetto pacchetto;
private boolean convalida = false;
private double prezzoFinale;

public Prenotazione() {
}

public Prenotazione(int numPartecipanti, Utente utente, Pacchetto pacchetto, boolean convalida, double prezzoFinale) {
	this.numPartecipanti = numPartecipanti;
	this.utente = utente;
	this.pacchetto = pacchetto;
	this.convalida = convalida;
	this.prezzoFinale = pacchetto.getCosto()*numPartecipanti;
}

public int getNumPartecipanti() {
	return numPartecipanti;
}
public void setNumPartecipanti(int numPartecipanti) {
	this.numPartecipanti = numPartecipanti;
}
public Utente getUtente() {
	return utente;
}
public void setUtente(Utente utente) {
	this.utente = utente;
}
public Pacchetto getPacchetto() {
	return pacchetto;
}
public void setPacchetto(Pacchetto pacchetto) {
	this.pacchetto = pacchetto;
}
public boolean isConvalida() {
	return convalida;
}
public void setConvalida(boolean convalida) {
	this.convalida = convalida;
}
public double getPrezzoFinale() {
	return prezzoFinale;
}
public void setPrezzoFinale(double prezzoFinale) {
	this.prezzoFinale = prezzoFinale;
}
public long getId() {
	return id;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + numPartecipanti;
	result = prime * result + ((utente == null) ? 0 : utente.hashCode());
	result = prime * result + ((pacchetto == null) ? 0 : pacchetto.hashCode());
	result = prime * result + (convalida ? 1231 : 1237);
	long temp;
	temp = Double.doubleToLongBits(prezzoFinale);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Prenotazione other = (Prenotazione) obj;
	if (id != other.id)
		return false;
	if (numPartecipanti != other.numPartecipanti)
		return false;
	if (utente == null) {
		if (other.utente != null)
			return false;
	} else if (!utente.equals(other.utente))
		return false;
	if (pacchetto == null) {
		if (other.pacchetto != null)
			return false;
	} else if (!pacchetto.equals(other.pacchetto))
		return false;
	if (convalida != other.convalida)
		return false;
	if (Double.doubleToLongBits(prezzoFinale) != Double.doubleToLongBits(other.prezzoFinale))
		return false;
	return true;
}

@Override
public String toString() {
	return "Prenotazione [id=" + id + ", numPartecipanti=" + numPartecipanti + ", utente=" + utente + ", pacchetto="
			+ pacchetto + ", convalida=" + convalida + ", prezzoFinale=" + prezzoFinale + "]";
}

public void calcolaPrezzo() {
	this.prezzoFinale = pacchetto.getCosto()*numPartecipanti;
}

}
