import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pacchetto } from 'src/app/models/pacchetto';
import { Observable, firstValueFrom } from 'rxjs';
import { Prenotazione } from 'src/app/models/prenotazione';
@Injectable({
  providedIn: 'root'
})
export class CatalogoService {

  apiGetUrl = "http://localhost:8080/pacchetti/all";
  pacchettoById = "http://localhost:8080/pacchetti/";
  pacchettoByContinente = "http://localhost:8080/pacchetti/continente=";
  nuovaPrenotazione = "http://localhost:8080/prenotazioni"
constructor(private http: HttpClient){ }
addPrenotazione(prenotazione : Prenotazione){
  return this.http.post(this.nuovaPrenotazione, prenotazione);
}
getPacchetti(){
return this.http.get(this.apiGetUrl)
}
findPacchettoById(id: number): Observable<Pacchetto> {
  const url = this.pacchettoById + id;
  return this.http.get<Pacchetto>(url);
}
// async getPacchettoById(id: number): Promise<Pacchetto> {
//   const url = this.pacchettoById + id;
//   const observable = this.http.get<Pacchetto>(url);
//   return firstValueFrom(observable);
// }
findPacchettiByContinente(continente : string): Observable<Pacchetto[]> {
  const url = this.pacchettoByContinente + continente;
  return this.http.get<Pacchetto[]>(url);
}
async getPacchettiByContinente(continente : string): Promise<Pacchetto[]> {
  const url = this.pacchettoByContinente + continente;
  const observable = this.http.get<Pacchetto[]>(url);
  return firstValueFrom(observable);
}
}