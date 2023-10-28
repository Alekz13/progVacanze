package agenziaViaggi.dto;

import java.util.Objects;


public class PrenotazioneDto {
	private Long id;
	private int numPartecipanti;
	private UtenteDto utente;
	private PacchettoDto pacchetto;
	private boolean convalida = false;
	private double prezzoFinale;
	public PrenotazioneDto() {
	}
	public PrenotazioneDto(Long id, int numPartecipanti, UtenteDto utente, PacchettoDto pacchetto, boolean convalida) {
		this.id = id;
		this.numPartecipanti = numPartecipanti;
		this.utente = utente;
		this.pacchetto = pacchetto;
		this.convalida = convalida;
		this.prezzoFinale = pacchetto.getCosto()*numPartecipanti;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumPartecipanti() {
		return numPartecipanti;
	}
	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}
	public UtenteDto getUtente() {
		return utente;
	}
	public void setUtente(UtenteDto utente) {
		this.utente = utente;
	}
	public PacchettoDto getPacchetto() {
		return pacchetto;
	}
	public void setPacchetto(PacchettoDto pacchetto) {
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
	
@Override
	public int hashCode() {
		return Objects.hash(convalida, numPartecipanti, pacchetto, prezzoFinale, utente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrenotazioneDto other = (PrenotazioneDto) obj;
		return convalida == other.convalida && numPartecipanti == other.numPartecipanti
				&& Objects.equals(pacchetto, other.pacchetto)
				&& Double.doubleToLongBits(prezzoFinale) == Double.doubleToLongBits(other.prezzoFinale)
				&& Objects.equals(utente, other.utente);
	}
public void calcolaPrezzo(double prezzo, int numPartecipanti) {
	this.prezzoFinale = prezzo*numPartecipanti; 
}

}
