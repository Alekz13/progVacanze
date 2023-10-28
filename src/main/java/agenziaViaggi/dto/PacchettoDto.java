package agenziaViaggi.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PacchettoDto {
	private Long id;
	private String nome, descrizione;
	private double costo;
	private int disponibilita;
	private boolean passaporto, vaccino;
	private LocalDate giornoPartenza, giornoRitorno;
	private MetaDto meta;
	public PacchettoDto() {
	}
	public PacchettoDto(Long id, String nome, String descrizione, double costo, int disponibilita,
			boolean passaporto, boolean vaccino, LocalDate giornoPartenza, LocalDate giornoRitorno, MetaDto meta) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.disponibilita = disponibilita;
		this.passaporto = passaporto;
		this.vaccino = vaccino;
		this.giornoPartenza = giornoPartenza;
		this.giornoRitorno = giornoRitorno;
		this.meta = meta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	public boolean isPassaporto() {
		return passaporto;
	}
	public void setPassaporto(boolean passaporto) {
		this.passaporto = passaporto;
	}
	public boolean isVaccino() {
		return vaccino;
	}
	public void setVaccino(boolean vaccino) {
		this.vaccino = vaccino;
	}
	public LocalDate getGiornoPartenza() {
		return giornoPartenza;
	}
	public void setGiornoPartenza(LocalDate giornoPartenza) {
		this.giornoPartenza = giornoPartenza;
	}
	public LocalDate getGiornoRitorno() {
		return giornoRitorno;
	}
	public void setGiornoRitorno(LocalDate giornoRitorno) {
		this.giornoRitorno = giornoRitorno;
	}
	public MetaDto getMeta() {
		return meta;
	}
	public void setMeta(MetaDto meta) {
		this.meta = meta;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(costo, descrizione, disponibilita, giornoPartenza, giornoRitorno, id, meta, nome,
				passaporto, vaccino);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacchettoDto other = (PacchettoDto) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(descrizione, other.descrizione) && disponibilita == other.disponibilita
				&& Objects.equals(giornoPartenza, other.giornoPartenza)
				&& Objects.equals(giornoRitorno, other.giornoRitorno) && Objects.equals(id, other.id)
				&& Objects.equals(meta, other.meta) && Objects.equals(nome, other.nome)
				&& passaporto == other.passaporto && vaccino == other.vaccino;
	}
	@Override
	public String toString() {
		return "PacchettoDto [nome=" + nome + ", descrizione=" + descrizione + ", costo=" + costo + ", disponibilita="
				+ disponibilita + ", passaporto=" + passaporto + ", vaccino="
				+ vaccino + ", giornoPartenza=" + giornoPartenza + ", giornoRitorno=" + giornoRitorno + ", meta=" + meta
				+ "]";
	}
	
	
}
