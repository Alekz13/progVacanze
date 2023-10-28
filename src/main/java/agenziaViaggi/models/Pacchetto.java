package agenziaViaggi.models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pacchetti")
public class Pacchetto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_pacchetto")
	private long id;
	private String nome, descrizione;
	private double costo;
	private int disponibilita;
	private boolean passaporto, vaccino;
	private LocalDate giornoPartenza, giornoRitorno;
	private String img;
	@ManyToOne
	@JoinColumn(name = "id_meta")
	private Meta meta;
	public Pacchetto() {
	
	}
	public Pacchetto(String nome, String descrizione, double costo, int disponibilita,
			boolean passaporto, boolean vaccino, LocalDate giornoPartenza, LocalDate giornoRitorno, Meta meta, String img) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.disponibilita = disponibilita;
		this.passaporto = passaporto;
		this.vaccino = vaccino;
		this.giornoPartenza = giornoPartenza;
		this.giornoRitorno = giornoRitorno;
		this.meta = meta;
		this.img = img;
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
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public long getId() {
		return id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public int hashCode() {
		return Objects.hash(costo, descrizione, disponibilita, giornoPartenza, giornoRitorno, id, img, meta, nome,
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
		Pacchetto other = (Pacchetto) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(descrizione, other.descrizione) && disponibilita == other.disponibilita
				&& Objects.equals(giornoPartenza, other.giornoPartenza)
				&& Objects.equals(giornoRitorno, other.giornoRitorno) && id == other.id
				&& Objects.equals(img, other.img) && Objects.equals(meta, other.meta)
				&& Objects.equals(nome, other.nome) && passaporto == other.passaporto && vaccino == other.vaccino;
	}
	@Override
	public String toString() {
		return "Pacchetto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", costo=" + costo
				+ ", disponibilita=" + disponibilita + ", passaporto=" + passaporto + ", vaccino=" + vaccino
				+ ", giornoPartenza=" + giornoPartenza + ", giornoRitorno=" + giornoRitorno + ", img=" + img + ", meta="
				+ meta + "]";
	}
	
	
	
}
