package agenziaViaggi.models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utenti")
public class Utente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_utente")
private long id;
private String nome, cognome, emailAddress, password;
private int phoneNumber, promoCounter;
private boolean admin, enabled;
private LocalDate dataDiNascita;
@OneToMany(mappedBy = "utente")
private List<Prenotazione> prenotazioni;
	
public Utente() {}

public Utente(String nome, String cognome, String emailAddress, String password, LocalDate dataDiNascita, int phoneNumber) {
	this.nome = nome;
	this.cognome = cognome;
	this.emailAddress = emailAddress;
	this.password = password;
	this.dataDiNascita = dataDiNascita;
	this.phoneNumber = phoneNumber;
	this.admin = false;
	this.enabled = true;
	this.promoCounter = 0;
	this.prenotazioni = new ArrayList<Prenotazione>();
	
}


public void setPrenotazioni(List<Prenotazione> prenotazioni) {
	this.prenotazioni = prenotazioni;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getEmailAddress() {
	return emailAddress;
}

public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

public String getPassword() {
	return password;
}

public void changePassword(String password) {
	this.password = password;
}
public void setPassword(String password) {
	this.password = password;
}
public LocalDate getDataDiNascita() {
	return dataDiNascita;
}

public void setDataDiNascita(LocalDate dataDiNascita) {
	this.dataDiNascita = dataDiNascita;
}

public int getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public int getPromoCounter() {
	return promoCounter;
}

public void setPromoCounter(int promoCounter) {
	this.promoCounter = promoCounter;
}

public boolean isAdmin() {
	return admin;
}

public void setAdmin(boolean admin) {
	this.admin = admin;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public void addPrenotazione(Prenotazione p){
	this.prenotazioni.add(p);
}

public List<Prenotazione> getPrenotazioni() {
	return prenotazioni;
}


@Override
public int hashCode() {
	return Objects.hash(admin, cognome, emailAddress, enabled, dataDiNascita, id, nome, password, phoneNumber, promoCounter);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Utente other = (Utente) obj;
	return admin == other.admin && Objects.equals(cognome, other.cognome)
			&& Objects.equals(emailAddress, other.emailAddress) && enabled == other.enabled && dataDiNascita == other.dataDiNascita
			&& id == other.id && Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
			&& phoneNumber == other.phoneNumber && promoCounter == other.promoCounter;
}

@Override
public String toString() {
	return "Utente [nome=" + nome + ", cognome=" + cognome + "]";
}

public void enabled() {
	this.setEnabled(true);
}
public boolean isValidPassword(String password) {
	if (this.password == password)
		return true;
	return false;
}
public void prenota(){
	this.promoCounter++;
}
public double calcolaPromo(){
	double promo=0;
	for(Prenotazione p : prenotazioni){
		promo += p.getPrezzoFinale();
	}
	return promo/prenotazioni.size();
}

}
